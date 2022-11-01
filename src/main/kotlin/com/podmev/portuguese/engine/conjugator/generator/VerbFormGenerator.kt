package com.podmev.portuguese.engine.conjugator.generator

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.PastParticipleTenseConjugator
import com.podmev.portuguese.engine.utils.word.Wordifier

object VerbFormGenerator {

    fun pastParticipleHelper(){
//        val wrongMatches = getWrongMatches(
//            etalonConjugator = OnlyDataSetConjugator,
//            checkingConjugator = AnalyticConjugator,
//            verbForms = OnlyDataSetConjugator.getConjugatorCoveringDataWithFixedTense(PastParticipleTense).getAllVerbFormInfos()
//        )
//        //TODO add sort by ends
//        for (match in wrongMatches.distinct()){
//            println("\"${match.form.infinitive}\", \"${match.correctForm.first()}\", \"${match.wrongForm.first()}\"")
//        }
        Wordifier.groupByEndOfWords(PastParticipleTenseConjugator.fullIrregularFormMap.keys.toList()).forEach {
            println(it)
        }
//        for (match in wrongMatches.distinct()){
//            println("Pair(\"${match.form.infinitive}\", \"${match.correctForm.first()}\"),")
//        }
    }

    fun getWrongMatches(
        etalonConjugator: Conjugator,
        checkingConjugator: Conjugator,
        verbForms: Iterable<VerbFormInfo>
    ): List<WrongMatch>{
        val wrongMatches = ArrayList<WrongMatch>()
        for(verbForm in verbForms){
            val etalonForm = etalonConjugator.conjugateVerb(verbForm.infinitive, verbForm.tense, verbForm.getVerbArgs())
            val checkingForm = checkingConjugator.conjugateVerb(verbForm.infinitive, verbForm.tense, verbForm.getVerbArgs())
            if(etalonForm!=checkingForm){
                wrongMatches.add(WrongMatch(verbForm, etalonForm, checkingForm))
            }
        }
        return wrongMatches
    }

    data class WrongMatch(val form: VerbFormInfo, val correctForm: List<String>, val wrongForm: List<String>)
}