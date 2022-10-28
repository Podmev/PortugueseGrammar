package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object P_Letter : AbstractLetter() {
    override val uppercase: Char = 'P'
    override val lowercase: Char = 'p'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}