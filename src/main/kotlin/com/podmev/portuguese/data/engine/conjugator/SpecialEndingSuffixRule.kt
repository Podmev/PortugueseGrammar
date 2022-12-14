package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.engine.conjugator.analytic.VerbLists

interface SpecialEndingSuffixRule {
    val wordEnding: String
    fun getSuffix(verb: String, regularSuffix: SuffixGroup): SuffixGroup

    //in case we need to set rule only for fixed list of verbs, but not for any with current word-ending
    val fixedVerbList: List<String>
        get() = emptyList()

    val exceptions: List<String>
        get() = emptyList()

    fun fitsVerb(verb: String): Boolean {
        if(!verb.endsWith(wordEnding)){
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