package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.cedilla

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CedillaDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.C_Letter

object C_Cedilla_Letter : AbstractDiacriticLetter() {
    override val uppercase: Char = 'Ç'
    override val lowercase: Char = 'ç'
    override fun baseLetter(): Letter = C_Letter
    override val diacriticMark: DiacriticMark = CedillaDiacriticMark
}