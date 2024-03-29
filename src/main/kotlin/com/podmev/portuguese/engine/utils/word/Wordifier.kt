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

    fun addDiacriticsToLastLetterByPredicate(
        word: String,
        diacriticMark: DiacriticMark,
        predicate: (Char)->Boolean
    ): String {
        val lastCharByPredicate = word.findLast (predicate)!!
        val genericLetter = Alphabet.parseExactLetter(lastCharByPredicate)!!.genericLetter
        val diacriticLetter: DiacriticLetter = genericLetter.changeDiacriticsMark(diacriticMark)
            ?: throw Exception("Cannot add $diacriticMark to letter $genericLetter")
        return replaceLastFoundGenericLetter(word, genericLetter, diacriticLetter)
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

    fun deleteAllDiacriticMarks(
        word: String
    ): String {
        val exactLetters: List<ExactLetter> = word2ExactLetters(word)
        val exactLettersWithoutDiacritics = exactLetters.map {
            it.genericLetter.baseLetter().exactLetterBySize(it.size)
        }
        return exactLetters2Word(exactLettersWithoutDiacritics)
    }

    fun deleteAllDiacriticMarksFromList(
        word: String,
        diacriticsMarksToDelete: List<DiacriticMark>
    ): String {
        val exactLetters: List<ExactLetter> = word2ExactLetters(word)
        val exactLettersWithoutDiacritics = exactLetters.map {
            val genericLetter = it.genericLetter
            val diacriticMark = genericLetter.diacriticMark
            if (diacriticMark != null && diacriticMark in diacriticsMarksToDelete) {
                genericLetter.baseLetter().exactLetterBySize(it.size)
            } else {
                it
            }
        }
        return exactLetters2Word(exactLettersWithoutDiacritics)
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

    fun replaceLastFoundGenericLetterInPrefix(
        word: String,
        prefix: String,
        fromGenericLetter: GenericLetter,
        toGenericLetter: GenericLetter
    ): String {
        assert(word.startsWith(prefix))
        val suffix = word.drop(prefix.length)
        val changedPrefix = replaceLastFoundGenericLetter(prefix, fromGenericLetter, toGenericLetter)
        return changedPrefix + suffix
    }

    fun putDiacriticMarkOnLastVowelInPrefix(
        word: String,
        prefix: String,
        diacriticMark: DiacriticMark
    ): String {
        assert(word.startsWith(prefix))
        val suffix = word.drop(prefix.length)
        val vowelChar = prefix.findLast { Alphabet.isVowelChar(it) }!!
        val vowel = Alphabet.parseExactLetter(vowelChar)!!.genericLetter.baseLetter()
        val changedPrefix = addDiacriticsToLastFoundLetter(
            word = prefix,
            letter = vowel,
            diacriticMark = diacriticMark
        )
        return changedPrefix + suffix
    }

    fun groupByEndOfWords(words: List<String>): Map<String, List<String>> {
        val map: Map<String, MutableList<String>> = words.associateWith { mutableListOf<String>() }
        val usedSet: MutableSet<String> = mutableSetOf<String>()
        for (word in words) {
            for ((key, list) in map) {
                if (key != word && word.endsWith(key)) {
                    list.add(word)
                    usedSet.add(word)
                }
            }
        }
        return map.filter { entry -> entry.value.isNotEmpty() || !usedSet.contains(entry.key) }
    }

    fun replaceEnding(word: String, originalEnding: String, replacementEnding: String): String {
        assert(word.endsWith(originalEnding))
        return word.dropLast(originalEnding.length) + replacementEnding
    }

    fun word2ExactLetters(word: String): List<ExactLetter> =
        word.map {
            Alphabet.parseExactLetter(it)
                ?: throw Exception("Char $it is cannot be parsed by Alphabet.parseExactLetter")
        }

    fun exactLetters2Word(exactLetters: List<ExactLetter>): String =
        exactLetters.map { it.view }.joinToString("")

    //TODO make tests for endsWithAny
    fun endsWithAny(word: String, endings: List<String>): Boolean = endings.any { word.endsWith(it) }

    fun countVowels(word: String) = word.count { Alphabet.isVowelChar(it) }
    fun countConsonants(word: String) = word.count { Alphabet.isConsonantChar(it) }

    fun findLastVowelExactLetter(word: String): ExactLetter? =
        findLastVowelChar(word)?.let { Alphabet.parseExactLetter(it) }

    fun findLastVowelChar(word: String): Char? = word.findLast { Alphabet.isVowelChar(it) }

    /*checks if word truncated in the end with n-characters finishes with ending
    * endsWithDroppingLast("indicar", "c", 2) == true
    *  */
    fun endsWithDroppingLast(word: String, ending: String, n: Int): Boolean = word.dropLast(n).endsWith(ending)

    //TODO rewrite better
    fun <E> replaceElementByIndex(list: List<E>, index: Int, newValue: E): List<E> {
        return list.mapIndexed { i: Int, value: E -> if (i == index) newValue else value }
    }
}