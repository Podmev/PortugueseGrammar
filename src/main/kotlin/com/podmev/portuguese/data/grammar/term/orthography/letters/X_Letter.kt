package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object X_Letter : AbstractLetter() {
    override val uppercase: Char = 'X'
    override val lowercase: Char = 'x'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}