package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter

object E_Grave_Letter : DiacriticLetter {
    override val uppercase: Char = 'È'
    override val lowercase: Char = 'è'
    override fun baseLetter(): Letter = E_Letter
    override val diacriticMark: DiacriticMark = GraveDiacriticMark
    override fun obsolete(): Boolean = true
}