package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.tense.expression.ExpressionTense
import com.podmev.portuguese.data.grammar.term.tense.periphrastic.PeriphrasticTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugatorLocalizer
import com.podmev.portuguese.engine.conjugator.analytic.tense.expression.ExpressionTenseConjugatorLocalizer
import com.podmev.portuguese.engine.conjugator.analytic.tense.periphrastic.PeriphrasticTenseConjugator

//TODO make somehow specific tense in each Conjugators
object AnalyticConjugator : Conjugator, ConjugatorLocalizer<GrammaticalTense> {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> = conjugatorLocalize(tense).conjugateVerb(verbInInfinitive, tense, verbArgs, settings)

    override fun conjugatorLocalize(tense: GrammaticalTense): Conjugator =
        when (tense) {
            is BasicTense -> BasicTenseConjugatorLocalizer.conjugatorLocalize(tense)
            is PeriphrasticTense -> PeriphrasticTenseConjugator
            is ExpressionTense -> ExpressionTenseConjugatorLocalizer.conjugatorLocalize(tense)
            else -> throw Exception("Unknown tense")
        }
}