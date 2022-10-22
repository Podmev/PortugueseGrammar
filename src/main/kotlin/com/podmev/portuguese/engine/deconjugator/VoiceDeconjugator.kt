package com.podmev.portuguese.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

interface VoiceDeconjugator {
    fun getTenseByVerbForm(string: String): GrammaticalTense
}