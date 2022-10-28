package com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark

object AcuteDiacriticMark : DiacriticMark {
    override val englishTerm: String = "Acute accent"
    override val portugueseTerm: String = "Acento agudo"
    override val symbol: String = "◌́"
    override val obsolete: Boolean = false
    override val meaning: String =
        "Indicates that a vowel is stressed and the quality of the accented vowel and, more precisely, " +
                "its height: á, é, and ó are low vowels (except in nasal vowels)"
}