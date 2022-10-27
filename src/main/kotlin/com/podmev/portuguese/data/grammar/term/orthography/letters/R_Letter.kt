package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object R_Letter : AbstractLetter() {
    override val uppercase: Char = 'R'
    override val lowercase: Char = 'r'
    override val category: LetterCategory = LetterCategory.CONSONANT
}