package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.U_Letter

object U_Grave_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ù'
    override val lowercase: Char = 'ù'
    override val baseLetter: Letter = U_Letter
    override val diacriticMark: DiacriticMark = GraveDiacriticMark
    override fun obsolete(): Boolean = true
}