package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.A_Letter

object A_Circumflex_Letter : AbstractDiacriticLetter() {
    override val uppercase: Char = 'Â'
    override val lowercase: Char = 'â'
    override fun baseLetter(): Letter = A_Letter
    override val diacriticMark: DiacriticMark = CircumflexDiacriticMark
}