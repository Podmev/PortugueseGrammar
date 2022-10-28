package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.E_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.E_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.E_Grave_Letter

object E_Letter : AbstractLetter() {
    override val uppercase: Char = 'E'
    override val lowercase: Char = 'e'
    override val category: LetterCategory = LetterCategory.VOWEL

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(
        E_Acute_Letter,
        E_Circumflex_Letter,
        E_Grave_Letter
    )

}