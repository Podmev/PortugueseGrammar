package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.Letter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object A_Letter : Letter {
    override val uppercase: Char = 'A'
    override val lowercase: Char = 'a'
    override val category: LetterCategory = LetterCategory.VOWEL
}