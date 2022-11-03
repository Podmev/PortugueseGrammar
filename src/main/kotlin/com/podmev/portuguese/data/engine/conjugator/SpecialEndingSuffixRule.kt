package com.podmev.portuguese.data.engine.conjugator

interface SpecialEndingSuffixRule {
    val wordEnding: String
    fun getSuffix(verb: String, regularSuffix: SuffixGroup): SuffixGroup

    //in case we need to set rule only for fixed list of verbs, but not for any with current word-ending
    val fixedVerbList: List<String>
        get() = emptyList()

    fun fitsVerb(verb: String): Boolean {
        if(!verb.endsWith(wordEnding)){
            return false
        }
        if(fixedVerbList.isEmpty()){
            return true
        }
        return verb in fixedVerbList
    }
}