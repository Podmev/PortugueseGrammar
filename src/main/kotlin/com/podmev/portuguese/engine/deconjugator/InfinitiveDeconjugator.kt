package com.podmev.portuguese.engine.deconjugator

interface InfinitiveDeconjugator {
    fun getInfinitiveByVerbForm(verbForm: String): List<String>
}