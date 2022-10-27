package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator

object PastParticipleForSerEstarTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        //NOTE check list of exceptions then use form of PastParticipleTense
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "PastParticipleForSerEstarTenseConjugator"
    }
}