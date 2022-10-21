package com.podmev.portuguese.engine.conjugator

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

interface Conjugator {

    /*conjugate verb according to given tense and arguments
    * usually result is one form. if form doesn't exist, so it will be empty list
    * In some rare cases it can be more than one option of form
    * */
    fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String>
}