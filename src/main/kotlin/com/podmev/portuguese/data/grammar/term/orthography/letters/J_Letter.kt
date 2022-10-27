package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object J_Letter : AbstractLetter() {
    override val uppercase: Char = 'J'
    override val lowercase: Char = 'j'
    override val category: LetterCategory = LetterCategory.CONSONANT
}