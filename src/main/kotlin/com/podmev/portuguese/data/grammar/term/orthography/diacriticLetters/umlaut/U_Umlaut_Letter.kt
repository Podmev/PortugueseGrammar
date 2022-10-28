package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.umlaut

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.UmlautDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.U_Letter

object U_Umlaut_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ü'
    override val lowercase: Char = 'ü'
    override fun baseLetter(): Letter = U_Letter
    override val diacriticMark: DiacriticMark = UmlautDiacriticMark
}