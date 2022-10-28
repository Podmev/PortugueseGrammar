package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.E_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.E_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.E_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.I_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark

object I_Letter : AbstractLetter() {
    override val uppercase: Char = 'I'
    override val lowercase: Char = 'i'
    override fun category(): LetterCategory = LetterCategory.VOWEL

    override fun addDiacriticMark(mark: DiacriticMark): DiacriticLetter? =
        when(mark){
            AcuteDiacriticMark -> I_Acute_Letter
            GraveDiacriticMark -> I_Grave_Letter
            else -> null
        }

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        I_Acute_Letter,
        I_Grave_Letter
    )
}