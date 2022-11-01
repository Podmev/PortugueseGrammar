package com.podmev.portuguese.engine.utils.verb.searchRules

import com.podmev.portuguese.data.grammar.term.orthography.GenericLetter
import com.podmev.portuguese.engine.utils.word.Wordifier

interface PreparingRule{
    fun prepareEntries(pairs: List<Pair<String, String>>): List<Pair<String, String>>
}

class LetterInFrontRule(val letter: GenericLetter): PreparingRule{
    override fun prepareEntries(pairs: List<Pair<String, String>>): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        for(pair in pairs){
            val (verb, form) = pair
            if(verb.startsWith(letter.lowercase) && form.startsWith(letter.lowercase)){
                list.add(Pair(verb.drop(1), form.drop(1)))
            } else{
                list.add(pair)
            }
        }
        return list
    }
}

object DiacriticsRule: PreparingRule{
    override fun prepareEntries(pairs: List<Pair<String, String>>): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        for(pair in pairs){
            val (verb, form) = pair
            val verbWithoutDiacritics = Wordifier.deleteAllDiacriticMarks(verb)
            list.add(pair)
            if(verb!=verbWithoutDiacritics){
                //add additionally extra form without diacritics
                list.add(Pair(verbWithoutDiacritics, form))
            }
        }
        return list
    }
}