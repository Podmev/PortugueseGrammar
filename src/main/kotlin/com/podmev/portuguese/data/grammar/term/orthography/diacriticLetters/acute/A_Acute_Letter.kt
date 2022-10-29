package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.A_Letter

object A_Acute_Letter : AbstractDiacriticLetter() {
    override val uppercase: Char = 'Á'
    override val lowercase: Char = 'á'
    override fun baseLetter(): Letter = A_Letter
    override val diacriticMark: DiacriticMark = AcuteDiacriticMark
}