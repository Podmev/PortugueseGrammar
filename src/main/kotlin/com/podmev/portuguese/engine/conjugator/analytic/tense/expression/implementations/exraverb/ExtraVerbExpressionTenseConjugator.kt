package com.podmev.portuguese.engine.conjugator.analytic.tense.expression.implementations.exraverb

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.expression.ExpressionTenseConjugator

/*all with extra verb are the same*/
object ExtraVerbExpressionTenseConjugator : ExpressionTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "ExtraVerbExpressionTenseConjugator"
    }

}