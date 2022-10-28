package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.A_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.E_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.A_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.E_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.A_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.E_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.A_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.TildeDiacriticMark

object E_Letter : AbstractLetter() {
    override val uppercase: Char = 'E'
    override val lowercase: Char = 'e'
    override fun category(): LetterCategory = LetterCategory.VOWEL

    override fun addDiacriticMark(mark: DiacriticMark): DiacriticLetter? =
        when(mark){
            AcuteDiacriticMark -> E_Acute_Letter
            CircumflexDiacriticMark -> E_Circumflex_Letter
            GraveDiacriticMark -> E_Grave_Letter
            else -> null
        }

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        E_Acute_Letter,
        E_Circumflex_Letter,
        E_Grave_Letter
    )

}