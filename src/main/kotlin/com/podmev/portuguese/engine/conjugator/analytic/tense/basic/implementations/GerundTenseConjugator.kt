package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator

object GerundTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        return listOf(regularChanging(verbInInfinitive))
    }

    private fun regularChanging(verbInInfinitive: String):String = verbInInfinitive.dropLast(1) + "ndo"

    override fun toString(): String {
        return "GerundTenseConjugator"
    }
}