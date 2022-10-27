package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object T_Letter : AbstractLetter() {
    override val uppercase: Char = 'T'
    override val lowercase: Char = 't'
    override val category: LetterCategory = LetterCategory.CONSONANT
}