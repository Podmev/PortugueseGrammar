package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter

object O_Acute_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ó'
    override val lowercase: Char = 'ó'
    override val baseLetter: Letter = O_Letter
    override val diacriticMark: DiacriticMark = AcuteDiacriticMark
}