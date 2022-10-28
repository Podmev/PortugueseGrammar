package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.I_Grave_Letter

object I_Letter : AbstractLetter() {
    override val uppercase: Char = 'I'
    override val lowercase: Char = 'i'
    override fun category(): LetterCategory = LetterCategory.VOWEL

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        I_Acute_Letter,
        I_Grave_Letter
    )
}