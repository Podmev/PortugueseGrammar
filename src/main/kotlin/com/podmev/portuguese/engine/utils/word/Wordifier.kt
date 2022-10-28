package com.podmev.portuguese.engine.utils.word

import com.podmev.portuguese.data.grammar.term.orthography.*

object Wordifier {
    fun addDiacriticsToLastFoundLetter(
        word: String,
        letter: Letter,
        diacriticMark: DiacriticMark
    ): String {
        val diacriticLetter: DiacriticLetter = letter.addDiacriticMark(diacriticMark)
            ?: throw Exception("Cannot add $diacriticMark to letter $letter")
        return replaceLastFoundGeneralLetter(word, letter, diacriticLetter)
    }

    fun replaceLastFoundGeneralLetter(
        word: String,
        fromGeneralLetter: GenericLetter,
        toGeneralLetter: GenericLetter
    ): String {
        /*not very optimal, but anyway*/
        val exactLetters: List<ExactLetter> = word2ExactLetters(word)
        val genericLetters = exactLetters.map { it.genericLetter }
        val replacementIndex: Int = genericLetters.lastIndexOf(fromGeneralLetter)
        val exactLetterForChanging: ExactLetter = exactLetters[replacementIndex]
        val letterSize: LetterSize = exactLetterForChanging.size
        val exactLetterReplacement: ExactLetter = toGeneralLetter.exactLetterBySize(letterSize)
        val updatedExactLetters = replaceElementByIndex(exactLetters, replacementIndex, exactLetterReplacement)
        return exactLetters2Word(updatedExactLetters)
    }

    fun word2ExactLetters(word: String): List<ExactLetter> =
        word.map {
            Alphabet.parseExactLetter(it)
                ?: throw Exception("Char $it is cannot be parsed by Alphabet.parseExactLetter")
        }

    fun exactLetters2Word(exactLetters :List<ExactLetter>): String =
        exactLetters.map {it.view}.joinToString ("")

    //TODO rewrite better
    fun <E> replaceElementByIndex(list: List<E>, index: Int, newValue: E): List<E>{
        return list.mapIndexed{i: Int, value: E -> if(i==index) newValue else value}
    }
}