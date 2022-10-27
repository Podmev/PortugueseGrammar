package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object S_Letter : AbstractLetter() {
    override val uppercase: Char = 'S'
    override val lowercase: Char = 's'
    override val category: LetterCategory = LetterCategory.CONSONANT
}