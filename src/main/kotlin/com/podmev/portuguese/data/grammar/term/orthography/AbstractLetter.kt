package com.podmev.portuguese.data.grammar.term.orthography

abstract class AbstractLetter : Letter {
    override fun toString(): String = "${uppercase}_Letter"
    /*for the most of the letters there is no related diacritic letters*/
    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf()

    override val baseLetter:Letter
        get() = this
}