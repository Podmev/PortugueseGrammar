package com.podmev.portuguese.data.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

interface TenseDeconjugator {
    fun getTenseByVerbForm(verbForm: String): List<GrammaticalTense>
}