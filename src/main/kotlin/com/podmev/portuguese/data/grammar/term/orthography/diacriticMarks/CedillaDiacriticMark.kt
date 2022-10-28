package com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark

object CedillaDiacriticMark : DiacriticMark {
    override val englishTerm: String = "Cedilla"
    override val portugueseTerm: String = "Cedilha"
    override val symbol: String = "◌̧"
    override val obsolete: Boolean = false
    override val meaning: String =
        "The cedilla indicates that ç is pronounced /s/ (from a historic palatalization). " +
                "By convention, s is written instead of etymological ç at the beginning of words, " +
                "as in \"São\", the hypocoristic form of the female name \"Conceição\"."
}