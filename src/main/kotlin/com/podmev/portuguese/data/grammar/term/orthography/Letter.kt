package com.podmev.portuguese.data.grammar.term.orthography

interface Letter : GenericLetter{
    override val uppercase: Char
    override val lowercase: Char
    override val category: LetterCategory

    val relatedDiacriticLetters: List<DiacriticLetter>

}