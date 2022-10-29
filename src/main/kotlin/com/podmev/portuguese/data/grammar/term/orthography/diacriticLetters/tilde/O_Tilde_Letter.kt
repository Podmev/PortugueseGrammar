package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.TildeDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter

object O_Tilde_Letter : AbstractDiacriticLetter() {
    override val uppercase: Char = 'Õ'
    override val lowercase: Char = 'õ'
    override fun baseLetter(): Letter = O_Letter
    override val diacriticMark: DiacriticMark = TildeDiacriticMark
}