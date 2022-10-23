package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo

data class ConjugatorCoveringData(
    val verbInfinitives: List<String>,
    val tenses: List<GrammaticalTense>,
    val persons: List<GrammaticalPerson>,
    val numbers: List<GrammaticalNumber>,
    val genders: List<GrammaticalGender>,
    val voices: List<GrammaticalVoice>,
){
    //TODO look how to make iterables with for-comprehension
//    fun getAllVerbFormInfos(): Iterable<VerbFormInfo>  =
//        {for (verb in verbInfinitives)
//            VerbFormInfo(verb)
//        }

}
