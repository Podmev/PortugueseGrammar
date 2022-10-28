package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object D_Letter : AbstractLetter() {
    override val uppercase: Char = 'D'
    override val lowercase: Char = 'd'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}