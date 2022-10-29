package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter

object I_Grave_Letter : AbstractDiacriticLetter() {
    override val uppercase: Char = 'Ì'
    override val lowercase: Char = 'ì'
    override fun baseLetter(): Letter = I_Letter
    override val diacriticMark: DiacriticMark = GraveDiacriticMark
    override fun obsolete(): Boolean = true
}