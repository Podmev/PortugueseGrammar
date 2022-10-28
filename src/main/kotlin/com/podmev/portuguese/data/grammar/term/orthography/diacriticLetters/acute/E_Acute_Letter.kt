package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter

object E_Acute_Letter : DiacriticLetter {
    override val uppercase: Char = 'É'
    override val lowercase: Char = 'é'
    override val baseLetter: Letter = E_Letter
    override val diacriticMark: DiacriticMark = AcuteDiacriticMark
}