package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup

interface SpecialEndingSuffixRule {
    val wordEnding: String
    fun getSuffix(verb: String, regularSuffix: SuffixGroup) : SuffixGroup
}