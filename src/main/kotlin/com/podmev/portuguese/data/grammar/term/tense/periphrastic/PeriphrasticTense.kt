package com.podmev.portuguese.data.grammar.term.tense.periphrastic

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.TenseCategory

data class PeriphrasticTense(
    val tenseCategory: TenseCategory,
    val periphrasticTenseType: PeriphrasticTenseType
) : GrammaticalTense{
    override fun toString(): String {
        return "PeriphrasticTense(tenseCategory=$tenseCategory, periphrasticTenseType=$periphrasticTenseType)"
    }
}