package com.podmev.portuguese.data.grammar.term.orthography

interface DiacriticMark {
    val englishTerm: String
    val portugueseTerm: String
    /*cannot use char, because of size - too big*/
    val symbol: String

    /*is forbidden in actual grammar (can be found in ald texts)*/
    val obsolete:Boolean
    val meaning: String
}