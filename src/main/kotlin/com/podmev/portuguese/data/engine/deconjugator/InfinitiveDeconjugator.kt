package com.podmev.portuguese.data.engine.deconjugator

interface InfinitiveDeconjugator {
    fun getInfinitiveByVerbForm(verbForm: String): List<String>
}