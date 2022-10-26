package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.engine.conjugator.analytic.ConjugatorLocalizer

object IndicativeMoodTenseConjugatorLocalizer : ConjugatorLocalizer<IndicativeMoodTense> {
    override fun conjugatorLocalize(tense: IndicativeMoodTense): Conjugator =
    when (tense) {
        is IndicativePresentTense -> IndicativePresentTenseConjugator
        is IndicativePreteriteTense -> IndicativePreteriteTenseConjugator
        is IndicativePluperfectTense -> IndicativePluperfectTenseConjugator
        is IndicativeFutureTense -> IndicativeFutureTenseConjugator
        is IndicativeImperfectTense -> IndicativeImperfectTenseConjugator

        else -> throw Exception("Unknown tense")
    }
}