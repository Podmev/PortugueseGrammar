package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup
import com.podmev.portuguese.engine.utils.verb.VerbEnds

interface FiniteTenseConjugator {
    val arSuffix: SuffixGroup
    val erSuffix: SuffixGroup
    val irSuffix: SuffixGroup

    val specialEndingSuffixRules: List<SpecialEndingSuffixRule>

    fun getSuffixGroup(verb: String): SuffixGroup? {
        val regularSuffix = getRegularSuffixGroup(verb) ?: return null
        val specialEndingSuffix = getSpecialSuffixGroup(verb, regularSuffix)
        return specialEndingSuffix ?: regularSuffix
    }

    private fun getSpecialSuffixGroup(verb: String, regularSuffix : SuffixGroup): SuffixGroup? {
        for (rule in specialEndingSuffixRules){
            if(verb.endsWith(rule.wordEnding)){
                return rule.getSuffix(verb, regularSuffix)
            }
        }
        return null
    }

    private fun getRegularSuffixGroup(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> arSuffix
            verb.endsWith(VerbEnds.ER) -> erSuffix
            verb.endsWith(VerbEnds.IR) -> irSuffix
            else -> null
        }
}