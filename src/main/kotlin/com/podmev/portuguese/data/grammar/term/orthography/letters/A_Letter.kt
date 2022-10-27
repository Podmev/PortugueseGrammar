package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object A_Letter : AbstractLetter() {
    override val uppercase: Char = 'A'
    override val lowercase: Char = 'a'
    override val category: LetterCategory = LetterCategory.VOWEL
}