package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object O_Letter : AbstractLetter() {
    override val uppercase: Char = 'O'
    override val lowercase: Char = 'o'
    override val category: LetterCategory = LetterCategory.VOWEL
}