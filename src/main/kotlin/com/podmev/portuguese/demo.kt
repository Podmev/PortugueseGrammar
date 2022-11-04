package com.podmev.portuguese

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.PastParticipleTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePresentTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.PastParticipleTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative.IndicativePresentTenseConjugator
import com.podmev.portuguese.engine.conjugator.generator.VerbFormGenerator
import com.podmev.portuguese.engine.dataset.verb.findInputVerbMeta
import com.podmev.portuguese.reader.convertInputVerbMetaToVerbFormInfoMap

fun main() {
//    getAllVerbs().forEach {
//        println(it)
//    }

//    getAllInputVerbMetas().take(3).forEach{
//        println(it)
//    }

//    println(findInputVerbMeta("estar"))

//    getAllConjugationGroups().forEach {
//        println(it)
//    }

//    val verbMeta = findInputVerbMeta("estar")!!
//    convertInputVerbMetaToVerbFormInfoMap(verbMeta).forEach { println(it) }
//    VerbFormGenerator.pastParticipleHelper()
//    println(PastParticipleTenseConjugator.conjugateVerb(
//        "oppôr",
//        PastParticipleTense,
//        VerbArguments(
//            GrammaticalPerson.UNDEFINED,
//            GrammaticalNumber.SINGULAR,
//            GrammaticalGender.FEMININE,
//            GrammaticalVoice.ACTIVE
//        )
//    ))

    println(IndicativePresentTenseConjugator.conjugateVerb(
        "medir",
        IndicativePresentTense,
        VerbArguments(
            GrammaticalPerson.FIRST,
            GrammaticalNumber.SINGULAR,
            GrammaticalGender.UNDEFINED,
            GrammaticalVoice.ACTIVE
        )
    ))
}