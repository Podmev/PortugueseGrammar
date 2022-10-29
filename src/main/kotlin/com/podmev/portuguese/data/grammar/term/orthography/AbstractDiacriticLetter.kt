package com.podmev.portuguese.data.grammar.term.orthography

abstract class AbstractDiacriticLetter : DiacriticLetter {
    override fun toString(): String = "${baseLetter().uppercase}_${diacriticMark.shortEnglishTerm}_Letter"
}