package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup
import com.podmev.portuguese.engine.utils.verb.VerbEnds

interface FiniteTenseConjugator {
    val arSuffix: SuffixGroup
    val erSuffix: SuffixGroup
    val irSuffix: SuffixGroup

    fun getRegularSuffixGroup(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> arSuffix
            verb.endsWith(VerbEnds.ER) -> erSuffix
            verb.endsWith(VerbEnds.IR) -> irSuffix
            else -> null
        }
}