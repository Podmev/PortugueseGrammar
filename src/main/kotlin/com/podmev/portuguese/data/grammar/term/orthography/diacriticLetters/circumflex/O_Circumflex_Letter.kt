package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter

object O_Circumflex_Letter : DiacriticLetter {
    override val uppercase: Char = 'Ô'
    override val lowercase: Char = 'ô'
    override fun baseLetter(): Letter = O_Letter
    override val diacriticMark: DiacriticMark = CircumflexDiacriticMark
}