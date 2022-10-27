package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object V_Letter : AbstractLetter() {
    override val uppercase: Char = 'V'
    override val lowercase: Char = 'v'
    override val category: LetterCategory = LetterCategory.CONSONANT
}