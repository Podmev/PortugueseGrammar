package com.podmev.portuguese.engine.conjugator.analytic.tense.basic

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.AffirmativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.ImperativeMoodTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativeMoodTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveMoodTense
import com.podmev.portuguese.engine.conjugator.analytic.ConjugatorLocalizer
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.*
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.condicional.ConditionalTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative.AffirmativeImperativeTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative.ImperativeMoodTenseConjugatorLocalizer
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative.IndicativeMoodTenseConjugatorLocalizer
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive.SubjunctiveMoodTenseConjugatorLocalizer

object BasicTenseConjugatorLocalizer : ConjugatorLocalizer<BasicTense> {
    override fun conjugatorLocalize(tense: BasicTense): Conjugator =
        when (tense) {
            is ConditionalTense -> ConditionalTenseConjugator
            is ImperativeMoodTense -> ImperativeMoodTenseConjugatorLocalizer.conjugatorLocalize(tense)
            is IndicativeMoodTense -> IndicativeMoodTenseConjugatorLocalizer.conjugatorLocalize(tense)
            is SubjunctiveMoodTense -> SubjunctiveMoodTenseConjugatorLocalizer.conjugatorLocalize(tense)

            is GerundTense -> GerundTenseConjugator
            is InfinitiveTense -> InfinitiveTenseConjugator
            is PastParticipleTense -> PastParticipleTenseConjugator
            is PastParticipleForSerEstarTense -> PastParticipleForSerEstarTenseConjugator
            is PersonalInfinitiveTense -> PersonalInfinitiveTenseConjugator

            else -> throw Exception("Unknown tense")
        }
}