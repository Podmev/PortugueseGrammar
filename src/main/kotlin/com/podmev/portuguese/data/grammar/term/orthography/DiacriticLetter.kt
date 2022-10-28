package com.podmev.portuguese.data.grammar.term.orthography

interface DiacriticLetter : GenericLetter{
    override val uppercase: Char
    override val lowercase: Char
    override fun baseLetter(): Letter
    override val diacriticMark: DiacriticMark

    /*is forbidden in actual grammar (can be found in ald texts)*/
    override fun obsolete(): Boolean = diacriticMark.obsolete
    override fun category(): LetterCategory = baseLetter().category()
}