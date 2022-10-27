package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object W_Letter : AbstractLetter() {
    override val uppercase: Char = 'W'
    override val lowercase: Char = 'w'
    override val category: LetterCategory = LetterCategory.CONSONANT
}