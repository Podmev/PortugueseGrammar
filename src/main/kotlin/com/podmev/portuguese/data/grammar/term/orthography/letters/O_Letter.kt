package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.A_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.O_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.A_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.A_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.O_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.A_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.O_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.GraveDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.TildeDiacriticMark

object O_Letter : AbstractLetter() {
    override val uppercase: Char = 'O'
    override val lowercase: Char = 'o'
    override fun category(): LetterCategory = LetterCategory.VOWEL

    override fun addDiacriticMark(mark: DiacriticMark): DiacriticLetter? =
        when(mark){
            AcuteDiacriticMark -> O_Acute_Letter
            CircumflexDiacriticMark -> O_Circumflex_Letter
            GraveDiacriticMark -> O_Grave_Letter
            TildeDiacriticMark -> O_Tilde_Letter
            else -> null
        }

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        O_Acute_Letter,
        O_Circumflex_Letter,
        O_Grave_Letter,
        O_Tilde_Letter
    )
}