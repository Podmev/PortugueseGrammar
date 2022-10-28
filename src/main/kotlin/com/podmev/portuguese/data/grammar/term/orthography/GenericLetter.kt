package com.podmev.portuguese.data.grammar.term.orthography
/*Letter or diacritic letter*/
interface GenericLetter {
    val uppercase: Char
    val lowercase: Char
    val diacriticMark: DiacriticMark?

    fun baseLetter(): Letter
    fun category(): LetterCategory
    /*is forbidden in actual grammar (can be found in ald texts)*/
    fun obsolete(): Boolean

}