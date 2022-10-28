package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object N_Letter : AbstractLetter() {
    override val uppercase: Char = 'N'
    override val lowercase: Char = 'n'
    override fun category(): LetterCategory = LetterCategory.CONSONANT
}