package com.podmev.portuguese.engine.conjugator.analytic.tense.expression

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.expression.ExpressionTense
import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense
import com.podmev.portuguese.engine.conjugator.analytic.ConjugatorLocalizer
import com.podmev.portuguese.engine.conjugator.analytic.tense.expression.implementations.exraverb.ExtraVerbExpressionTenseConjugator


object ExpressionTenseConjugatorLocalizer : ConjugatorLocalizer<ExpressionTense> {
    override fun conjugatorLocalize(tense: ExpressionTense): Conjugator =
        when (tense) {
            is ExtraVerbExpressionTense -> ExtraVerbExpressionTenseConjugator
            else -> throw Exception("Unknown tense")
        }

}