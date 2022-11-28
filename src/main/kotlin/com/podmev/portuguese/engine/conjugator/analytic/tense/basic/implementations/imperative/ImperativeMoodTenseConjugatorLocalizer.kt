package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.AffirmativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.ImperativeMoodTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.NegativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.engine.conjugator.analytic.ConjugatorLocalizer

object ImperativeMoodTenseConjugatorLocalizer : ConjugatorLocalizer<ImperativeMoodTense> {
    override fun conjugatorLocalize(tense: ImperativeMoodTense): Conjugator =
        when (tense) {
            is AffirmativeImperativeTense -> AffirmativeImperativeTenseConjugator
            is NegativeImperativeTense -> NegativeImperativeTenseConjugator
            else -> throw Exception("Unknown tense")
        }
}