package com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative

import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

/*Note: there is affirmative and negative version, but there is no need to use in model*/
object ImperativeTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.IMPERATIVE
    override val canHavePerson: Boolean
        get() = true
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = true

    override fun toString(): String {
        return "ImperativeTense"
    }
}