package com.podmev.portuguese.engine.conjugator.analytic.tense.periphrastic

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.SingleTenseConjugator

object PeriphrasticTenseConjugator : SingleTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "PeriphrasticTenseConjugator"
    }
}