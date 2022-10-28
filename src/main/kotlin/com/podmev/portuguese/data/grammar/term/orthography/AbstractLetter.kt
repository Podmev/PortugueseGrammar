package com.podmev.portuguese.data.grammar.term.orthography

abstract class AbstractLetter : Letter {
    override fun toString(): String = "${uppercase}_Letter"

    /*for the most of the letters there is no related diacritic letters except for 6*/
    override val relatedDiacriticLetters: List<DiacriticLetter> = listOf()
    override val diacriticMark: DiacriticMark? = null
    override fun addDiacriticMark(mark: DiacriticMark): DiacriticLetter? = null

    override fun baseLetter(): Letter = this
    /*base letters are not obsolete*/
    override fun obsolete(): Boolean = false

}