package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.A_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.A_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.A_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.A_Tilde_Letter

object A_Letter : AbstractLetter() {
    override val uppercase: Char = 'A'
    override val lowercase: Char = 'a'
    override val category: LetterCategory = LetterCategory.VOWEL

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        A_Acute_Letter,
        A_Circumflex_Letter,
        A_Grave_Letter,
        A_Tilde_Letter
    )
}