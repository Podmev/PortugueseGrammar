package com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark

object CircumflexDiacriticMark : DiacriticMark {
    override val englishTerm: String = "Circumflex"
    override val shortEnglishTerm: String = "Circumflex"
    override val portugueseTerm: String = "Acento circunflexo"
    override val symbol: String = "◌̂"
    override val obsolete: Boolean = false
    override val meaning: String =
        "Indicates that a vowel is stressed and the quality of the accented vowel and, more precisely, " +
                "its height: â, ê, and ô are high vowels"
}