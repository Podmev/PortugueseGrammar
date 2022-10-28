package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.O_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.U_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.O_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.U_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.O_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.umlaut.U_Umlaut_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.*

object U_Letter : AbstractLetter() {
    override val uppercase: Char = 'U'
    override val lowercase: Char = 'u'
    override fun category(): LetterCategory = LetterCategory.VOWEL

    override fun addDiacriticMark(mark: DiacriticMark): DiacriticLetter? =
        when(mark){
            AcuteDiacriticMark -> U_Acute_Letter
            GraveDiacriticMark -> U_Grave_Letter
            UmlautDiacriticMark -> U_Umlaut_Letter
            else -> null
        }

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        U_Acute_Letter,
        U_Grave_Letter,
        U_Umlaut_Letter
    )
}