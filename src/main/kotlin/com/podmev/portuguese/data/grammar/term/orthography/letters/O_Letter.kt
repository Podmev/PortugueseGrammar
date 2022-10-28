package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.O_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.O_Grave_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.O_Tilde_Letter

object O_Letter : AbstractLetter() {
    override val uppercase: Char = 'O'
    override val lowercase: Char = 'o'
    override val category: LetterCategory = LetterCategory.VOWEL

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        O_Acute_Letter,
        O_Circumflex_Letter,
        O_Grave_Letter,
        O_Tilde_Letter
    )
}