package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.E_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.other.PortugueseLocale
import com.podmev.portuguese.data.other.PortugueseLocale.*
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.utils.lang.mergeListMaps
import com.podmev.portuguese.utils.lang.revertListMap
import java.util.logging.Logger

abstract class FiniteTenseConjugator() : Conjugator {
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

    //usually not needed
    open val specialVerbBaseByTense: SpecialVerbBaseByTense? = null

    var defectiveGroupByVerbMap: Map<String, DefectiveGroup> = createDefectiveGroupByVerbMap()

    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> {
        logger.fine("conjugateVerb $verbInInfinitive started for $tense $verbArgs $settings")
        if (!settings.ignoreDefective) {
            val defectiveGroup: DefectiveGroup? = getDefectiveGroup(verbInInfinitive)
            if (defectiveGroup?.hasForm(verbArgs) == false) {
                //form doesn't exist, so it is empty
                return emptyList()
            }
        }
        val regularTransformation = regularChanging(verbInInfinitive, verbArgs, settings)
        val irregularForm = irregularChanging(verbInInfinitive, verbArgs, regularTransformation, settings)
        if (irregularForm != null) {
            return irregularForm //can be list
        }
        //irregular form doesn't exist so use regular
        if (regularTransformation != null) {
            return listOf(regularTransformation.regularForm)
        }
        return listOf()
    }

    /* origin irregular or derivative from one
    * */
    private fun irregularChanging(
        verb: String,
        verbArgs: VerbArguments,
        regularTransformation: RegularTransformation?,
        settings: ConjugateSettings
    ): List<String>? {
        val irregularForm: IrregularForm? = irregularForms[verb]
        if (irregularForm != null) {
            return applyIrregularChanging(verb, irregularForm, verbArgs, regularTransformation)
        }
        //trying to find derivatives
        val originIrregularVerb: String = VerbLists.irregularVerbOriginMap[verb] ?: return null
        val originIrregularForm = irregularForms[originIrregularVerb]
        val originRegularTransformation = regularChanging(originIrregularVerb, verbArgs, settings)
        if (originIrregularForm != null) {
            return applyDerivativeIrregularChanging(
                verb = verb,
                verbArgs = verbArgs,
                //TODO extract class for 3 next params, but cannot create appropriate name
                originIrregularVerb = originIrregularVerb,
                originIrregularForm = originIrregularForm,
                originRegularTransformation = originRegularTransformation
            )
        }
        //verb in irregular list, but no irregular form for it
        return null
    }

    private fun applyIrregularChanging(
        verb: String,
        irregularForm: IrregularForm,
        verbArgs: VerbArguments,
        regularTransformation: RegularTransformation?
    ): List<String>? = irregularForm.getForm(verbArgs, regularTransformation)

    private fun applyDerivativeIrregularChanging(
        verb: String,
        verbArgs: VerbArguments,
        originIrregularVerb: String,
        originIrregularForm: IrregularForm,
        originRegularTransformation: RegularTransformation?
    ): List<String>? {
        val originForm: List<String> = originIrregularForm.getForm(verbArgs, originRegularTransformation) ?: return null
        val (diff: String, dropAtStart: Int) = VerbHelper.diffVerbAndOrigin(verb, originIrregularVerb)
        return originForm.map { singleOriginForm ->
            diff + addDiacriticsOnOriginFormForDerivative(
                singleOriginForm,
                diff
            ).drop(dropAtStart)
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

    private fun regularChanging(verb: String, verbArgs: VerbArguments, settings: ConjugateSettings): RegularTransformation? {
        val suffixGroup = getSuffixGroup(verb, settings) ?: return null //in case of -or
        val suffix = suffixGroup.getSuffix(verbArgs)!! //for regular should not apear
        val preparedBase = prepareBase(verb, suffix, suffixGroup, verbArgs, settings)
        val regularTransformation = RegularTransformation(preparedBase + suffix, preparedBase, suffix, suffixGroup)
        return regularTransformation
    }

    fun getSuffixGroup(verb: String, settings: ConjugateSettings): SuffixGroup? {
        val regularSuffix = getRegularSuffixGroup(verb, settings.portugueseLocale) ?: return null
        val specialEndingSuffix = getSpecialSuffixGroup(verb, regularSuffix)
        return specialEndingSuffix ?: regularSuffix
    }

    private fun prepareBase(verb: String, suffix: String, suffixGroup: SuffixGroup, verbArgs: VerbArguments, settings: ConjugateSettings): String {
        val specialBasePlusInfinitiveEnding = specialVerbBaseByTense?.getBasePlusInfinitiveEnding(verb, settings)
        val usingVerb: String = specialBasePlusInfinitiveEnding ?: verb
        val preparedInfinitive = prepareInfinitive(
            originalInfinitive = verb,
            usingInfinitive = usingVerb,
            suffix = suffix,
            verbArgs = verbArgs
        )
        return VerbHelper.dropInfinitiveSuffixByLength(
            infinitive = preparedInfinitive,
            lengthToDrop = suffixGroup.droppingSuffixLength
        )
    }

    private fun getRegularSuffixGroup(verb: String, portugueseLocale: PortugueseLocale): SuffixGroup? =
        when(portugueseLocale){
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

    private fun prepareInfinitive(originalInfinitive: String,
                                  usingInfinitive: String, suffix: String, verbArgs: VerbArguments): String {
        var currentResult = usingInfinitive
        for (rule in baseChangingRules) {
            if (rule.isCorrectForm(verbArgs) && rule.fitsVerb(originalInfinitive)) {
                val changeBaseIfPossible: String? = rule.changeBaseIfPossible(currentResult, suffix, verbArgs)
                if (changeBaseIfPossible != null) {
                    currentResult = changeBaseIfPossible
                }
            }
        }
        return currentResult
    }

    private fun totalDefectiveGroups(): Map<DefectiveGroup, List<String>> =
        mergeListMaps(currentDefectiveGroups, VerbLists.commonDefectiveVerbGroups)

    private fun createDefectiveGroupByVerbMap(): Map<String, DefectiveGroup> =
        revertListMap(totalDefectiveGroups())

    private fun getDefectiveGroup(verb: String): DefectiveGroup? = defectiveGroupByVerbMap[verb]
}