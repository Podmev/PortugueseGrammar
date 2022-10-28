package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.U_Letter

object U_Acute_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ú'
    override val lowercase: Char = 'ú'
    override val baseLetter: Letter = U_Letter
    override val diacriticMark: DiacriticMark = AcuteDiacriticMark
}