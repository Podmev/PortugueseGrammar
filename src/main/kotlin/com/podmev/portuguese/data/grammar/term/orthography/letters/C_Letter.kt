package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object C_Letter : AbstractLetter() {
    override val uppercase: Char = 'C'
    override val lowercase: Char = 'c'
    override val category: LetterCategory = LetterCategory.CONSONANT
}