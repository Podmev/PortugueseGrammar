package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.E_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.other.PortugueseLocale
import com.podmev.portuguese.data.other.PortugueseLocale.BRAZIL
import com.podmev.portuguese.data.other.PortugueseLocale.PORTUGAL
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.utils.lang.mergeListMaps
import com.podmev.portuguese.utils.lang.revertListMap
import java.util.logging.Logger

abstract class FiniteTenseConjugator : Conjugator {
    private val logger: Logger = Logger.getLogger("FiniteTenseConjugator")

    //default is brazilian
    abstract val arSuffix: SuffixGroup
    abstract val erSuffix: SuffixGroup
    abstract val irSuffix: SuffixGroup

    open val arSuffixPortugal: SuffixGroup by lazy { arSuffix }
    open val erSuffixPortugal: SuffixGroup by lazy { erSuffix }
    open val irSuffixPortugal: SuffixGroup by lazy { irSuffix }

    abstract val irregularForms: Map<String, IrregularForm>
    abstract val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
    abstract val baseChangingRules: List<BaseChangingRule>
    abstract val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
    open val commonDefectiveGroups: Map<DefectiveGroup, List<String>> =
        VerbLists.commonDefectiveVerbGroups

    //usually not needed
    open val specialVerbBaseByTense: SpecialVerbBaseByTense? = null

    /*use forms from this conjugator if there is - for imperative*/
    open val originConjugator: Conjugator? = null

    open val globalDefectiveGroup = trueDefectiveGroup

    var defectiveGroupByVerbMap: Map<String, DefectiveGroup> = createDefectiveGroupByVerbMap()

    /*using mostly in presente indicativo*/
    open val autoAddAcuteToE_LetterInDerivativesWith1Vowel: Boolean = false

    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> {
        logger.fine("conjugateVerb $verbInInfinitive started for $tense $verbArgs $settings")
        //defectiveness by verb
        if (!settings.ignoreDefective) {
            val defectiveGroup: DefectiveGroup? = getDefectiveGroup(verbInInfinitive)
            if (defectiveGroup?.hasForm(verbArgs) == false) {
                //form doesn't exist, so it is empty
                return emptyList()
            }
        }
        //global defectiveness
        if (globalDefectiveGroup.hasForm(verbArgs) == false) {
            //form doesn't exist, so it is empty
            return emptyList()
        }
        if (originConjugator != null) {
            return originConjugator!!.conjugateVerb(verbInInfinitive, tense, verbArgs, settings)
        }

        val regularTransformations: List<RegularTransformation> = regularChanging(verbInInfinitive, verbArgs, settings)
        val irregularForm = irregularChanging(verbInInfinitive, verbArgs, regularTransformations, settings)
        if (irregularForm != null) {
            return irregularForm //can be list
        }
        //irregular form doesn't exist so use regular
        return regularTransformations.map { it.regularForm }
    }

    /* origin irregular or derivative from one
    * */
    private fun irregularChanging(
        verb: String,
        verbArgs: VerbArguments,
        regularTransformations: List<RegularTransformation>,
        settings: ConjugateSettings
    ): List<String>? {

        val irregularForm: IrregularForm? = irregularForms[verb]
        if (irregularForm != null) {
            return applyIrregularChanging(
                verb = verb,
                irregularForm = irregularForm,
                verbArgs = verbArgs,
                regularTransformations = regularTransformations,
                portugueseLocale = settings.portugueseLocale
            )
        }
        //trying to find derivatives
        val originIrregularVerb: String = VerbLists.irregularVerbOriginMap[verb] ?: return null
        val originIrregularForm = irregularForms[originIrregularVerb]
        val originRegularTransformations: List<RegularTransformation> =
            regularChanging(originIrregularVerb, verbArgs, settings)
        if (originIrregularForm != null) {
            return applyDerivativeIrregularChanging(
                verb = verb,
                verbArgs = verbArgs,
                //TODO extract class for 3 next params, but cannot create appropriate name
                originIrregularVerb = originIrregularVerb,
                originIrregularForm = originIrregularForm,
                originRegularTransformations = originRegularTransformations,
                portugueseLocale = settings.portugueseLocale
            )
        }
        //verb in irregular list, but no irregular form for it
        return null
    }

    private fun applyIrregularChanging(
        verb: String,
        irregularForm: IrregularForm,
        verbArgs: VerbArguments,
        regularTransformations: List<RegularTransformation>,
        portugueseLocale: PortugueseLocale
    ): List<String>? = irregularForm.getForm(verbArgs, regularTransformations, portugueseLocale)

    private fun applyDerivativeIrregularChanging(
        verb: String,
        verbArgs: VerbArguments,
        originIrregularVerb: String,
        originIrregularForm: IrregularForm,
        originRegularTransformations: List<RegularTransformation>,
        portugueseLocale: PortugueseLocale
    ): List<String>? {
        val originForm: List<String> =
            originIrregularForm.getForm(verbArgs, originRegularTransformations, portugueseLocale) ?: return null
        val (diff: String, dropAtStart: Int) = VerbHelper.diffVerbAndOrigin(verb, originIrregularVerb)
        return originForm.map { singleOriginForm ->
            val modifiedOriginBase =
                if (autoAddAcuteToE_LetterInDerivativesWith1Vowel)
                    addDiacriticsOnOriginFormForDerivative(
                        singleOriginForm,
                        diff
                    )
                else singleOriginForm
            diff + modifiedOriginBase.drop(dropAtStart)
        }
    }

    //TODO rewrite with cilaba tonica rules
    private fun addDiacriticsOnOriginFormForDerivative(originForm: String, diff: String): String {
        if (Wordifier.countVowels(originForm) == 1 &&
            Wordifier.countVowels(diff) >= 1 &&
            Wordifier.findLastVowelExactLetter(originForm)!!.genericLetter == E_Letter
        ) {
            return Wordifier.replaceLastFoundGenericLetter(originForm, E_Letter, E_Acute_Letter)
            //only if there is only single vowel, and it is 'e' in origin form, and diff has vowels
        }
        return originForm
    }

    private fun regularChanging(
        verb: String,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<RegularTransformation> {
        val suffixGroup = getSuffixGroup(verb, settings) ?: return emptyList() //in case of -or
        val suffix = suffixGroup.getSuffix(verbArgs)!! //for regular should not apear
        val preparedBases: List<String> = prepareBase(verb, suffix, suffixGroup, verbArgs, settings)
        return preparedBases.map { preparedBase ->
            RegularTransformation(preparedBase + suffix, preparedBase, suffix, suffixGroup)
        }
    }

    fun getSuffixGroup(verb: String, settings: ConjugateSettings): SuffixGroup? {
        val regularSuffix = getRegularSuffixGroup(verb, settings.portugueseLocale) ?: return null
        val specialEndingSuffix = getSpecialSuffixGroup(verb, regularSuffix)
        return specialEndingSuffix ?: regularSuffix
    }

    private fun prepareBase(
        verb: String,
        suffix: String,
        suffixGroup: SuffixGroup,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> {
        val specialBasePlusInfinitiveEnding = specialVerbBaseByTense?.getBasePlusInfinitiveEnding(verb, settings)
        val usingVerb: String = specialBasePlusInfinitiveEnding ?: verb
        val preparedInfinitiveList: List<String> = prepareInfinitive(
            originalInfinitive = verb,
            usingInfinitive = usingVerb,
            suffix = suffix,
            verbArgs = verbArgs,
            portugueseLocale = settings.portugueseLocale
        )
        return preparedInfinitiveList.map { infinitive ->
            VerbHelper.dropInfinitiveSuffixByLength(
                infinitive = infinitive,
                lengthToDrop = suffixGroup.droppingSuffixLength
            )
        }
    }

    private fun getRegularSuffixGroup(verb: String, portugueseLocale: PortugueseLocale): SuffixGroup? =
        when (portugueseLocale) {
            BRAZIL -> getRegularSuffixGroupBrazil(verb)
            PORTUGAL -> getRegularSuffixGroupPortugal(verb)
        }

    private fun getRegularSuffixGroupBrazil(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> arSuffix
            verb.endsWith(VerbEnds.ER) -> erSuffix
            verb.endsWith(VerbEnds.IR) -> irSuffix
            //pôr and others
            Wordifier.deleteAllDiacriticMarks(verb).endsWith(VerbEnds.OR) -> erSuffix
            else -> null
        }

    private fun getRegularSuffixGroupPortugal(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> arSuffixPortugal
            verb.endsWith(VerbEnds.ER) -> erSuffixPortugal
            verb.endsWith(VerbEnds.IR) -> irSuffixPortugal
            //pôr and others
            Wordifier.deleteAllDiacriticMarks(verb).endsWith(VerbEnds.OR) -> erSuffixPortugal
            else -> null
        }

    private fun getSpecialSuffixGroup(verb: String, regularSuffix: SuffixGroup): SuffixGroup? {
        for (rule in specialEndingSuffixRules) {
            if (rule.fitsVerb(verb)) {
                return rule.getSuffix(verb, regularSuffix)
            }
        }
        return null
    }

    private fun prepareInfinitive(
        originalInfinitive: String,
        usingInfinitive: String, suffix: String, verbArgs: VerbArguments,
        portugueseLocale: PortugueseLocale
    ): List<String> {
        val usingInfinitiveIsChanged = originalInfinitive != usingInfinitive
        var currentResult: List<String> = listOf(usingInfinitive)
        for (rule in baseChangingRules) {
            if (rule.isCorrectForm(verbArgs) && rule.fitsVerb(originalInfinitive, portugueseLocale)) {
                val oneRuleResult: ArrayList<String> = arrayListOf()
                for (oneOfCurrentForms in currentResult) {
                    val changeBaseIfPossible: List<String>? = rule.fullChangeBaseIfPossible(
                        verb = oneOfCurrentForms,
                        exactSuffix = suffix,
                        verbArgs = verbArgs,
                        verbIsChanged = usingInfinitiveIsChanged,
                        portugueseLocale = portugueseLocale
                    )
                    if (changeBaseIfPossible != null) {
                        oneRuleResult.addAll(changeBaseIfPossible)
                    }
                }
                if(oneRuleResult.isNotEmpty()) {
                    currentResult = oneRuleResult
                }
            }
        }
        return currentResult
    }

    private fun totalDefectiveGroups(): Map<DefectiveGroup, List<String>> =
        mergeListMaps(currentDefectiveGroups, commonDefectiveGroups)

    private fun createDefectiveGroupByVerbMap(): Map<String, DefectiveGroup> =
        revertListMap(totalDefectiveGroups())

    private fun getDefectiveGroup(verb: String): DefectiveGroup? = defectiveGroupByVerbMap[verb]
}