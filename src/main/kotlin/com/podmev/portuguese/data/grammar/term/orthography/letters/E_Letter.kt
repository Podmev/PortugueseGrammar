package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object E_Letter : AbstractLetter() {
    override val uppercase: Char = 'E'
    override val lowercase: Char = 'e'
    override val category: LetterCategory = LetterCategory.VOWEL
}