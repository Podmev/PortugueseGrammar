package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object G_Letter : AbstractLetter() {
    override val uppercase: Char = 'G'
    override val lowercase: Char = 'g'
    override val category: LetterCategory = LetterCategory.CONSONANT
}