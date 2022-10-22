package com.podmev.portuguese.data.grammar.term.tense.periphrastic

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.TenseCategory

data class PeriphrasticTense(
    val tenseCategory: TenseCategory,
    val periphrasticTenseType: PeriphrasticTenseType
) : GrammaticalTense