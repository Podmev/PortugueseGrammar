package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.TildeDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.A_Letter

object A_Tilde_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ã'
    override val lowercase: Char = 'ã'
    override fun baseLetter(): Letter = A_Letter
    override val diacriticMark: DiacriticMark = TildeDiacriticMark
}