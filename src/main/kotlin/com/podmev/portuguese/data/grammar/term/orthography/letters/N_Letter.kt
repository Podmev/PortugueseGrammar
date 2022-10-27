package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object N_Letter : Letter {
    override val uppercase: Char = 'N'
    override val lowercase: Char = 'n'
    override val category: LetterCategory = LetterCategory.CONSONANT
}