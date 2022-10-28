package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter

object E_Circumflex_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ê'
    override val lowercase: Char = 'ê'
    override fun baseLetter(): Letter = E_Letter
    override val diacriticMark: DiacriticMark = CircumflexDiacriticMark
}