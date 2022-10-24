package com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional

import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

object ConditionalTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.CONDICIONAL
    override val canHavePerson: Boolean
        get() = true
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = true

    override fun toString(): String {
        return "ConditionalTense"
    }
}