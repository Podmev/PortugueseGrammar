package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object Z_Letter : Letter {
    override val uppercase: Char = 'Z'
    override val lowercase: Char = 'z'
    override val category: LetterCategory = LetterCategory.CONSONANT
}