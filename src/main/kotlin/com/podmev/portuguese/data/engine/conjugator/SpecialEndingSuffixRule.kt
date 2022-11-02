package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup

interface SpecialEndingSuffixRule {
    val wordEnding: String
    fun getSuffix(verb: String, regularSuffix: SuffixGroup) : SuffixGroup
}