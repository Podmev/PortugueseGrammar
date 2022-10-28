package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object H_Letter : AbstractLetter() {
    override val uppercase: Char = 'H'
    override val lowercase: Char = 'h'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}