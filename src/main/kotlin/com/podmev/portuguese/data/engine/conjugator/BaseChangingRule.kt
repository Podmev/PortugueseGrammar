package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.VerbLists

interface BaseChangingRule {
    fun isCorrectForm(verbArgs: VerbArguments): Boolean
    /*shouldn't take ending ar, er, ir*/
    fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments, verbIsChanged: Boolean): String?

    val wordEnding: String?
        get() = null

    val wordPossibleEndings: List<String>
        get() = emptyList()

    //in case we need to set rule only for fixed list of verbs, but not for any with current word-ending
    val fixedVerbList: List<String>
        get() = emptyList()

    val exceptions: List<String>
        get() = emptyList()

    fun fitsVerb(verb: String): Boolean {
        if(wordEnding!=null && !verb.endsWith(wordEnding!!)){
            return false
        }
        if(wordPossibleEndings.isNotEmpty() && !wordPossibleEndings.any{verb.endsWith(it)}){
            return false
        }
        val originOrVerb: String = VerbLists.irregularVerbOriginMap[verb] ?: verb
        if(fixedVerbList.isNotEmpty()){
            return originOrVerb in fixedVerbList
        }
        if(originOrVerb in exceptions){
            return false
        }
        return true
    }
}