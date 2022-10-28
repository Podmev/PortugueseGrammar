package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object Z_Letter : AbstractLetter() {
    override val uppercase: Char = 'Z'
    override val lowercase: Char = 'z'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}