package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object M_Letter : AbstractLetter() {
    override val uppercase: Char = 'M'
    override val lowercase: Char = 'm'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}