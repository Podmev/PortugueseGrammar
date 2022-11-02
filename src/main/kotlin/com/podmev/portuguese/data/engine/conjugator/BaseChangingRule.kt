package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

interface BaseChangingRule {
    fun isCorrectForm(verbArgs: VerbArguments): Boolean
    /*shouldn't take ending ar, er, ir*/
    fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String?
}