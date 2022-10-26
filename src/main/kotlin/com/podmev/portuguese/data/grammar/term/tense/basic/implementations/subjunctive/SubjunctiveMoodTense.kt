package com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

interface SubjunctiveMoodTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.SUBJUNCTIVE
    override val canHavePerson: Boolean
        get() = true
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = false
}