package com.podmev.portuguese.engine.conjugator.analytic.tense.periphrastic

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.SingleTenseConjugator

object PeriphrasticTenseConjugator : SingleTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "PeriphrasticTenseConjugator"
    }
}