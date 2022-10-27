package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object Y_Letter : AbstractLetter() {
    override val uppercase: Char = 'Y'
    override val lowercase: Char = 'y'
    override val category: LetterCategory = LetterCategory.VOWEL
}