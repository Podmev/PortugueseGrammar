package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter

/*rare*/
object O_Grave_Letter : AbstractDiacriticLetter() {
    override val uppercase: Char = 'Ò'
    override val lowercase: Char = 'ò'
    override fun baseLetter(): Letter = O_Letter
    override val diacriticMark: DiacriticMark = GraveDiacriticMark
}