package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

object SubjunctiveFutureTenseConjugator : SubjunctiveMoodTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "SubjunctiveFutureTenseConjugator"
    }
}