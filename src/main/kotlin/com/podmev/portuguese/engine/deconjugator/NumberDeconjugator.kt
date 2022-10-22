package com.podmev.portuguese.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber

interface NumberDeconjugator {
    fun getNumberByVerbForm(verbForm: String): List<GrammaticalNumber>
}