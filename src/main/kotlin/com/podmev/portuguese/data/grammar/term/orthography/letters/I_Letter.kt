package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object I_Letter : AbstractLetter() {
    override val uppercase: Char = 'I'
    override val lowercase: Char = 'i'
    override val category: LetterCategory = LetterCategory.VOWEL
}