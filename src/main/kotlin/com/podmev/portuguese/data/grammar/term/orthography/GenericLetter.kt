package com.podmev.portuguese.data.grammar.term.orthography

import com.podmev.portuguese.data.grammar.term.orthography.LetterSize.LOWER_CASE
import com.podmev.portuguese.data.grammar.term.orthography.LetterSize.UPPER_CASE

/*Letter or diacritic letter*/
interface GenericLetter {
    val uppercase: Char
    val lowercase: Char
    val diacriticMark: DiacriticMark?

    fun baseLetter(): Letter
    fun category(): LetterCategory
    /*is forbidden in actual grammar (can be found in ald texts)*/
    fun obsolete(): Boolean

    fun uppercaseExactLetter():ExactLetter = ExactLetter(this, UPPER_CASE)
    fun lowercaseExactLetter():ExactLetter = ExactLetter(this, LOWER_CASE)

    fun viewBySize(letterSize: LetterSize): Char =
        when(letterSize){
            UPPER_CASE -> uppercase
            LOWER_CASE -> lowercase
        }

    fun exactLetterBySize(letterSize: LetterSize): ExactLetter =
        when(letterSize){
            UPPER_CASE -> uppercaseExactLetter()
            LOWER_CASE -> lowercaseExactLetter()
        }

    fun allExactLetters(): List<ExactLetter> =
        listOf(uppercaseExactLetter(), lowercaseExactLetter())

    fun hasDiacritics() : Boolean = diacriticMark!=null
}