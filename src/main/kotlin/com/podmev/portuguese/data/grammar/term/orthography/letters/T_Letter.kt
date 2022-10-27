package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object T_Letter : Letter {
    override val uppercase: Char = 'T'
    override val lowercase: Char = 't'
    override val category: LetterCategory = LetterCategory.CONSONANT
}