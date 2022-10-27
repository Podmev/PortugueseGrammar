package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object F_Letter : AbstractLetter() {
    override val uppercase: Char = 'F'
    override val lowercase: Char = 'f'
    override val category: LetterCategory = LetterCategory.CONSONANT
}