package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.U_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.U_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.umlaut.U_Umlaut_Letter

object U_Letter : AbstractLetter() {
    override val uppercase: Char = 'U'
    override val lowercase: Char = 'u'
    override val category: LetterCategory = LetterCategory.VOWEL

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        U_Acute_Letter,
        U_Grave_Letter,
        U_Umlaut_Letter
    )
}