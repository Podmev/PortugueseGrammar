package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.BaseChangingRule
import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.engine.conjugator.SpecialEndingSuffixRule
import com.podmev.portuguese.data.engine.conjugator.SuffixGroup
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.utils.verb.VerbEnds

interface FiniteTenseConjugator : Conjugator {
    val arSuffix: SuffixGroup
    val erSuffix: SuffixGroup
    val irSuffix: SuffixGroup

    val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
    val baseChangingRules: List<BaseChangingRule>

    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        //TODO add exceptions
        val regularForm = regularChanging(verbInInfinitive, verbArgs)
        if (regularForm != null) {
            return listOf(regularForm)
        }
        return listOf()
    }

    private fun regularChanging(verb: String, verbArgs: VerbArguments): String? {
        val suffix = getSuffixGroup(verb)?.getSuffix(verbArgs) ?: return null //in case of -or
        val preparedBase = prepareBase(verb, suffix, verbArgs)
        return preparedBase + suffix
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