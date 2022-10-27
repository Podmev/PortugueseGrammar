package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object X_Letter : Letter {
    override val uppercase: Char = 'X'
    override val lowercase: Char = 'x'
    override val category: LetterCategory = LetterCategory.CONSONANT
}