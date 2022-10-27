package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object L_Letter : AbstractLetter() {
    override val uppercase: Char = 'L'
    override val lowercase: Char = 'l'
    override val category: LetterCategory = LetterCategory.CONSONANT
}