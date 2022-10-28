package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.A_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.cedilla.C_Cedilla_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.A_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.A_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.A_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.*

object C_Letter : AbstractLetter() {
    override val uppercase: Char = 'C'
    override val lowercase: Char = 'c'
    override fun category(): LetterCategory = LetterCategory.CONSONANT

    override fun addDiacriticMark(mark: DiacriticMark): DiacriticLetter? =
        when(mark){
            CedillaDiacriticMark -> C_Cedilla_Letter
            else -> null
        }

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(C_Cedilla_Letter)
}