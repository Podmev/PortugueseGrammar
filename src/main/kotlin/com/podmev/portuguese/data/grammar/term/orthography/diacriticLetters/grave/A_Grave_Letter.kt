package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.A_Letter

object A_Grave_Letter : DiacriticLetter {
    override val uppercase: Char = 'À'
    override val lowercase: Char = 'à'
    override val baseLetter: Letter = A_Letter
    override val diacriticMark: DiacriticMark = GraveDiacriticMark
}