package com.podmev.portuguese.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

interface NumberDeconjugator {
    fun getTenseByVerbForm(string: String): GrammaticalTense
}