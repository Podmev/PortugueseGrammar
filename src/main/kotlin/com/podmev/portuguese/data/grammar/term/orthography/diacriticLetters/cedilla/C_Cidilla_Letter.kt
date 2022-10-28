package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.cedilla

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CedillaDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.C_Letter

object C_Cidilla_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ç'
    override val lowercase: Char = 'ç'
    override val baseLetter: Letter = C_Letter
    override val diacriticMark: DiacriticMark = CedillaDiacriticMark
}