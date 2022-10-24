package com.podmev.portuguese.data.grammar.term.tense.periphrastic

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.TenseCategory
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

data class PeriphrasticTense(
    val tenseCategory: TenseCategory,
    val periphrasticTenseType: PeriphrasticTenseType
) : GrammaticalTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.INDICATIVE //TODO THINK WELL
    override val canHavePerson: Boolean
        get() = true
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = false

    override fun toString(): String {
        return "PeriphrasticTense(tenseCategory=$tenseCategory, periphrasticTenseType=$periphrasticTenseType)"
    }
}