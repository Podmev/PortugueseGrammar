package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.utils.lang.mergeListMaps
import com.podmev.portuguese.utils.lang.revertListMap

abstract class FiniteTenseConjugator() : Conjugator {
    abstract val arSuffix: SuffixGroup
    abstract val erSuffix: SuffixGroup
    abstract val irSuffix: SuffixGroup

    abstract val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
    abstract val baseChangingRules: List<BaseChangingRule>
    abstract val irregularForms: Map<String, IrregularForm>
    abstract val currentDefectiveGroups: Map<DefectiveGroup, List<String>>

    var defectiveGroupByVerbMap: Map<String, DefectiveGroup> = createDefectiveGroupByVerbMap()

    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        val defectiveGroup: DefectiveGroup? = getDefectiveGroup(verbInInfinitive)
        if(defectiveGroup?.hasForm(verbArgs) == false){
            //form doesn't exist, so it is empty
            return emptyList()
        }
        val regularTransformation = regularChanging(verbInInfinitive, verbArgs)
        val irregularForm = irregularChanging(verbInInfinitive, verbArgs, regularTransformation)
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
        regularTransformation: RegularTransformation?
    ): List<String>? {
        val irregularForm: IrregularForm? = irregularForms[verb]
        if (irregularForm != null) {
            return applyIrregularChanging(verb, irregularForm, verbArgs, regularTransformation)
        }
        //trying to find derivatives
        val originIrregularVerb: String = VerbLists.irregularVerbOriginMap[verb] ?: return null
        val originIrregularForm = irregularForms[originIrregularVerb]
        val originRegularTransformation = regularChanging(originIrregularVerb, verbArgs)
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
        val originForm = originIrregularForm.getForm(verbArgs, originRegularTransformation) ?: return null
        val (diff: String, dropAtStart: Int) = VerbHelper.diffVerbAndOrigin(verb, originIrregularVerb)
        return originForm.map { singleOriginForm -> diff + singleOriginForm.drop(dropAtStart) }
    }

    private fun regularChanging(verb: String, verbArgs: VerbArguments): RegularTransformation? {
        val suffixGroup = getSuffixGroup(verb) ?: return null //in case of -or
        val suffix = suffixGroup.getSuffix(verbArgs)!! //for regular should not apear
        val preparedBase = prepareBase(verb, suffix, suffixGroup, verbArgs)
        val regularTransformation = RegularTransformation(preparedBase + suffix, preparedBase, suffix, suffixGroup)
        return regularTransformation
    }

    fun getSuffixGroup(verb: String): SuffixGroup? {
        val regularSuffix = getRegularSuffixGroup(verb) ?: return null
        val specialEndingSuffix = getSpecialSuffixGroup(verb, regularSuffix)
        return specialEndingSuffix ?: regularSuffix
    }

    private fun prepareBase(verb: String, suffix: String, suffixGroup: SuffixGroup, verbArgs: VerbArguments): String {
        val preparedInfinitive = prepareInfinitive(verb, suffix, verbArgs)
        return VerbHelper.dropInfinitiveSuffixByLength(
            infinitive = preparedInfinitive,
            lengthToDrop = suffixGroup.droppingSuffixLength
        )
    }

    private fun getRegularSuffixGroup(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> arSuffix
            verb.endsWith(VerbEnds.ER) -> erSuffix
            verb.endsWith(VerbEnds.IR) -> irSuffix
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

    private fun prepareInfinitive(infinitive: String, suffix: String, verbArgs: VerbArguments): String {
        for (rule in baseChangingRules) {
            if (rule.isCorrectForm(verbArgs)) {
                val changeBaseIfPossible: String? = rule.changeBaseIfPossible(infinitive, suffix, verbArgs)
                if (changeBaseIfPossible != null) {
                    return changeBaseIfPossible
                }
            }
        }
        return infinitive
    }

    private fun totalDefectiveGroups():Map<DefectiveGroup, List<String>> =
        mergeListMaps(currentDefectiveGroups, VerbLists.commonDefectiveVerbGroups)

    private fun createDefectiveGroupByVerbMap():Map<String, DefectiveGroup> =
        revertListMap(totalDefectiveGroups())

    private fun getDefectiveGroup(verb: String): DefectiveGroup? = defectiveGroupByVerbMap[verb]
}