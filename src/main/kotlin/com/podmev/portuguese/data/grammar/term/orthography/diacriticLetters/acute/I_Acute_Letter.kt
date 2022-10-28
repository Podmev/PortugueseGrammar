package com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter

object I_Acute_Letter : DiacriticLetter {
    override val uppercase: Char = 'Í'
    override val lowercase: Char = 'í'
    override fun baseLetter(): Letter = I_Letter
    override val diacriticMark: DiacriticMark = AcuteDiacriticMark
}