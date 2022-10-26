package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.*
import com.podmev.portuguese.engine.conjugator.analytic.ConjugatorLocalizer

object SubjunctiveMoodTenseConjugatorLocalizer : ConjugatorLocalizer<SubjunctiveMoodTense> {
    override fun conjugatorLocalize(tense: SubjunctiveMoodTense): Conjugator =
    when (tense) {
        is SubjunctivePresentTense -> SubjunctivePresentTenseConjugator
        is SubjunctivePreteriteTense -> SubjunctivePreteriteTenseConjugator
        is SubjunctivePluperfectTense -> SubjunctivePluperfectTenseConjugator
        is SubjunctiveFutureTense -> SubjunctiveFutureTenseConjugator
        is SubjunctiveImperfectTense -> SubjunctiveImperfectTenseConjugator

        else -> throw Exception("Unknown tense")
    }
}