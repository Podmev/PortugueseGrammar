package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

interface ConjugatorLocalizer<Tense> where Tense : GrammaticalTense {
    fun conjugatorLocalize(tense: Tense): Conjugator
}