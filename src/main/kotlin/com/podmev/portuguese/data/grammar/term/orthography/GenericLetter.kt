package com.podmev.portuguese.data.grammar.term.orthography
/*Letter or diacritic letter*/
interface GenericLetter {
    val uppercase: Char
    val lowercase: Char
    val category: LetterCategory

    val baseLetter: Letter
    val diacriticMark: DiacriticMark?

}