package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.utils.verb.VerbEnds

interface FiniteTenseConjugator : Conjugator {
    val arSuffix: SuffixGroup
    val erSuffix: SuffixGroup
    val irSuffix: SuffixGroup

    val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
    val baseChangingRules: List<BaseChangingRule>
    val irregularForms: Map<String, IrregularForm>

    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
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
        if (originIrregularForm != null) {
            return applyDerivativeIrregularChanging(
                verb,
                originIrregularVerb,
                originIrregularForm,
                verbArgs,
                regularTransformation
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
        originIrregularVerb: String,
        originIrregularForm: IrregularForm,
        verbArgs: VerbArguments,
        regularTransformation: RegularTransformation?
    ): List<String>? {
        val originForm = originIrregularForm.getForm(verbArgs, regularTransformation) ?: return null
        val diff: String = VerbHelper.diffVerbAndOrigin(verb, originIrregularVerb)
        return originForm.map { singleOriginForm -> diff + singleOriginForm }
    }

    private fun regularChanging(verb: String, verbArgs: VerbArguments): RegularTransformation? {
        val suffixGroup = getSuffixGroup(verb) ?: return null //in case of -or
        val suffix = suffixGroup.getSuffix(verbArgs)
        val preparedBase = prepareBase(verb, suffix, verbArgs)
        val regularTransformation = RegularTransformation(preparedBase + suffix, preparedBase, suffix, suffixGroup)
        return regularTransformation
    }

    fun getSuffixGroup(verb: String): SuffixGroup? {
        val regularSuffix = getRegularSuffixGroup(verb) ?: return null
        val specialEndingSuffix = getSpecialSuffixGroup(verb, regularSuffix)
        return specialEndingSuffix ?: regularSuffix
    }

    private fun prepareBase(verb: String, suffix: String, verbArgs: VerbArguments): String =
        VerbHelper.dropInfinitiveSuffixXR(prepareInfinitive(verb, suffix, verbArgs))

    private fun getRegularSuffixGroup(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> arSuffix
            verb.endsWith(VerbEnds.ER) -> erSuffix
            verb.endsWith(VerbEnds.IR) -> irSuffix
            else -> null
        }

    private fun getSpecialSuffixGroup(verb: String, regularSuffix: SuffixGroup): SuffixGroup? {
        for (rule in specialEndingSuffixRules) {
            if (verb.endsWith(rule.wordEnding)) {
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
}