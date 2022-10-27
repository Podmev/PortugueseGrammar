package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object Q_Letter : AbstractLetter() {
    override val uppercase: Char = 'Q'
    override val lowercase: Char = 'q'
    override val category: LetterCategory = LetterCategory.CONSONANT
}