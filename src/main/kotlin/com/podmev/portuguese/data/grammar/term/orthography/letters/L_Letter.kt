package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object L_Letter : Letter {
    override val uppercase: Char = 'L'
    override val lowercase: Char = 'l'
    override val category: LetterCategory = LetterCategory.CONSONANT
}