package com.podmev.portuguese.data.grammar.term.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator

object InfinitiveTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "InfinitiveTenseConjugator"
    }
}