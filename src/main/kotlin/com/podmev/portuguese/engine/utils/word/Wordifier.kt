package com.podmev.portuguese.engine.utils.word

import com.podmev.portuguese.data.grammar.term.orthography.*

/*tools for changing words*/
object Wordifier {
    fun addDiacriticsToLastFoundLetter(
        word: String,
        letter: Letter,
        diacriticMark: DiacriticMark
    ): String {
        val diacriticLetter: DiacriticLetter = letter.addDiacriticMark(diacriticMark)
            ?: throw Exception("Cannot add $diacriticMark to letter $letter")
        return replaceLastFoundGenericLetter(word, letter, diacriticLetter)
    }

    fun deleteLastDiacritics(
        word: String
    ): String {
        /*not very optimal, but anyway*/
        val exactLetters: List<ExactLetter> = word2ExactLetters(word)
        val genericLetters = exactLetters.map { it.genericLetter }
        val replacementIndex: Int = genericLetters.indexOfLast(GenericLetter::hasDiacritics)
        val oldReplacementExactLetter = exactLetters[replacementIndex]
        val oldReplacementGenericLetter = oldReplacementExactLetter.genericLetter
        val newReplacementGenericLetter = oldReplacementGenericLetter.baseLetter()
        val letterSize: LetterSize = oldReplacementExactLetter.size
        val exactLetterReplacement: ExactLetter = newReplacementGenericLetter.exactLetterBySize(letterSize)
        val updatedExactLetters = replaceElementByIndex(exactLetters, replacementIndex, exactLetterReplacement)
        return exactLetters2Word(updatedExactLetters)
    }

    fun replaceLastFoundGenericLetter(
        word: String,
        fromGenericLetter: GenericLetter,
        toGenericLetter: GenericLetter
    ): String {
        /*not very optimal, but anyway*/
        val exactLetters: List<ExactLetter> = word2ExactLetters(word)
        val genericLetters = exactLetters.map { it.genericLetter }
        val replacementIndex: Int = genericLetters.lastIndexOf(fromGenericLetter)
        val exactLetterForChanging: ExactLetter = exactLetters[replacementIndex]
        val letterSize: LetterSize = exactLetterForChanging.size
        val exactLetterReplacement: ExactLetter = toGenericLetter.exactLetterBySize(letterSize)
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

    //TODO make tests for endsWithAny
    fun endsWithAny(word: String, endings: List<String>): Boolean = endings.any{word.endsWith(it)}

    //TODO rewrite better
    fun <E> replaceElementByIndex(list: List<E>, index: Int, newValue: E): List<E>{
        return list.mapIndexed{i: Int, value: E -> if(i==index) newValue else value}
    }
}