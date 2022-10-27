package com.podmev.portuguese.data.grammar.term.orthography.letters

import com.podmev.portuguese.data.grammar.term.orthography.AbstractLetter
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory

object U_Letter : AbstractLetter() {
    override val uppercase: Char = 'U'
    override val lowercase: Char = 'u'
    override val category: LetterCategory = LetterCategory.VOWEL
}