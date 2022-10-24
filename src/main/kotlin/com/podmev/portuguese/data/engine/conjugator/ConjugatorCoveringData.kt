package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo

/*
* persons, numbers and genders you can take from tense
* */
data class ConjugatorCoveringData(
    val verbInfinitives: List<String>,
    val tenses: List<GrammaticalTense>,
    val voices: List<GrammaticalVoice>
){

    /*
    *
example for for comprehension
fun pythagoreanTriples(n: Int) =
    (1..n).flatMap {
        x -> (x..n).flatMap {
            y -> (y..n).filter {
                z ->  x * x + y * y == z * z
            }.map { Triple(x, y, it) }
        }
    }

fun main(args: Array<String>) {
    println(pythagoreanTriples(20))
}
    * */
    //TODO look how to make iterables with for-comprehension
//    fun getAllVerbFormInfos(): Iterable<VerbFormInfo>  =
//        {for (verb in verbInfinitives)
//            VerbFormInfo(verb)
//        }

}
