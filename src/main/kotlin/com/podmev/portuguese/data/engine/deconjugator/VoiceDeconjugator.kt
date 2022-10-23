package com.podmev.portuguese.data.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice

interface VoiceDeconjugator {
    fun getVoiceByVerbForm(verbForm: String): List<GrammaticalVoice>
}