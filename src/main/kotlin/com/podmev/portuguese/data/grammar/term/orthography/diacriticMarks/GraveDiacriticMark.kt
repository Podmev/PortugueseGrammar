package com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticMark

object GraveDiacriticMark : AbstractDiacriticMark() {
    override val englishTerm: String = "Grave accent"
    override val shortEnglishTerm: String = "Grave"
    override val portugueseTerm: String = "Acento grave"
    override val symbol: String = "◌́"
    override val obsolete: Boolean = false
    override val meaning: String =
        """The grave accent marks the contraction of two consecutive vowels in adjacent words (crasis), 
            |normally the preposition a and an article or a demonstrative pronoun: a + aquela = àquela "at that", 
            |a + a = à "at the". It can also be used when indicating time: "às 4 horas" = "at 4 o'clock". 
            |It does not indicate stress.""".trimMargin()
}