package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.other.PortugueseLocale
import com.podmev.portuguese.engine.conjugator.analytic.VerbLists

interface BaseChangingRule {
    fun isCorrectForm(verbArgs: VerbArguments): Boolean

    /*shouldn't take ending ar, er, ir*/
    fun changeBaseIfPossible(
        verb: String,
        exactSuffix: String,
        verbArgs: VerbArguments,
        verbIsChanged: Boolean
    ): String?

    /*if changing it can be more than one form, for example both changed and unchanged are acceptable*/
    fun fullChangeBaseIfPossible(
        verb: String,
        exactSuffix: String,
        verbArgs: VerbArguments,
        verbIsChanged: Boolean,
        portugueseLocale: PortugueseLocale
    ): List<String>? {
        val simpleChanged = changeBaseIfPossible(verb, exactSuffix, verbArgs, verbIsChanged) ?: return null
        if (keepOriginalFormAsAlternative || keepOriginalFormAsAlternativeByLocale(portugueseLocale)) {
            return listOf(verb, simpleChanged)
        }
        return listOf(simpleChanged)
    }

    val wordEnding: String?
        get() = null

    val wordPossibleEndings: List<String>
        get() = emptyList()

    //in case we need to set rule only for fixed list of verbs, but not for any with current word-ending
    val fixedVerbList: List<String>
        get() = emptyList()

    val exceptions: List<String>
        get() = emptyList()

    val portugalExceptions: List<String>
        get() = emptyList()

    val brazilExceptions: List<String>
        get() = emptyList()

    fun exceptionsByLocale(portugueseLocale: PortugueseLocale): List<String> =
        when (portugueseLocale) {
            PortugueseLocale.BRAZIL -> brazilExceptions
            PortugueseLocale.PORTUGAL -> portugalExceptions
        }

    val keepOriginalFormAsAlternative: Boolean
        get() = false

    val portugalKeepOriginalFormAsAlternative: Boolean
        get() = false

    val brazilKeepOriginalFormAsAlternative: Boolean
        get() = false

    fun keepOriginalFormAsAlternativeByLocale(portugueseLocale: PortugueseLocale): Boolean =
        when (portugueseLocale) {
            PortugueseLocale.BRAZIL -> brazilKeepOriginalFormAsAlternative
            PortugueseLocale.PORTUGAL -> portugalKeepOriginalFormAsAlternative
        }

    fun fitsVerb(verb: String, portugueseLocale: PortugueseLocale): Boolean {
        if (wordEnding != null && !verb.endsWith(wordEnding!!)) {
            return false
        }
        if (wordPossibleEndings.isNotEmpty() && !wordPossibleEndings.any { verb.endsWith(it) }) {
            return false
        }
        val originOrVerb: String = VerbLists.irregularVerbOriginMap[verb] ?: verb
        if (fixedVerbList.isNotEmpty()) {
            return originOrVerb in fixedVerbList
        }
        if (originOrVerb in exceptions || originOrVerb in exceptionsByLocale(portugueseLocale)) {
            return false
        }
        return true
    }
}