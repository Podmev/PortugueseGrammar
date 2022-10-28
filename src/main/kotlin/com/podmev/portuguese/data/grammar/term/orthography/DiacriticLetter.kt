package com.podmev.portuguese.data.grammar.term.orthography

interface DiacriticLetter {
    val uppercase: Char
    val lowercase: Char
    val baseLetter: Letter
    val diacriticMark: DiacriticMark

    /*is forbidden in actual grammar (can be found in ald texts)*/
    fun obsolete(): Boolean = diacriticMark.obsolete
    fun category(): LetterCategory = baseLetter.category
}