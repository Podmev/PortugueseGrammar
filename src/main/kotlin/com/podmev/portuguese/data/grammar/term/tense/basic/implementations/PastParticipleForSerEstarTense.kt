package com.podmev.portuguese.data.grammar.term.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

object PastParticipleForSerEstarTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.UNDEFINED
    override val canHavePerson: Boolean
        get() = false
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = true

    override fun toString(): String {
        return "PastParticipleForSerEstarTense"
    }
}