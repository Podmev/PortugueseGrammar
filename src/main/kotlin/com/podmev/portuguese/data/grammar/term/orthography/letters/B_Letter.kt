package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object B_Letter : AbstractLetter() {
    override val uppercase: Char = 'B'
    override val lowercase: Char = 'b'
    override val category: LetterCategory = LetterCategory.CONSONANT
}