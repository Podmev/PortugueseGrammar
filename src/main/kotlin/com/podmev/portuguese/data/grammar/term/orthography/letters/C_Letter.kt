package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.DiacriticLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.cedilla.C_Cidilla_Letter

object C_Letter : AbstractLetter() {
    override val uppercase: Char = 'C'
    override val lowercase: Char = 'c'
    override val category: LetterCategory = LetterCategory.CONSONANT

    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf(C_Cidilla_Letter)
}