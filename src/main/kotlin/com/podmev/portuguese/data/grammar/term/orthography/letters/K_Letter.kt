package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object K_Letter : AbstractLetter() {
    override val uppercase: Char = 'K'
    override val lowercase: Char = 'k'
    override val category: LetterCategory = LetterCategory.CONSONANT
}