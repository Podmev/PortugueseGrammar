package com.podmev.portuguese.data.grammar.term.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

object GerundTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.UNDEFINED
    override val canHavePerson: Boolean
        get() = false
    override val canHaveNumber: Boolean
        get() = false
    override val canHaveGender: Boolean
        get() = false
    override fun toString(): String {
        return "GerundTense"
    }
}