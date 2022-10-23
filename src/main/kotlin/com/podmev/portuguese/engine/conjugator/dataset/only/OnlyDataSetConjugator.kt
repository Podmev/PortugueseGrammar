package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.ImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveImperfectTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePreteriteTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.grammar.term.verb.createVerbFormInfoWithVerbArgs
import com.podmev.portuguese.engine.dataset.verb.findInputVerbMeta
import com.podmev.portuguese.reader.convertInputVerbMetaToVerbFormInfoMap

//TODO make custom exceptions
/*uses only dataset, if there is no such tense throws exception*/
object OnlyDataSetConjugator : Conjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        val verbMeta =
            findInputVerbMeta(verbInInfinitive) ?: throw Exception("Verb $verbInInfinitive is not found in dataset")
        val verbFormInfoMap: Map<VerbFormInfo, String> = convertInputVerbMetaToVerbFormInfoMap(verbMeta)
        val currentVerbFormInfo = createVerbFormInfoWithVerbArgs(verbInInfinitive, tense, verbArgs)
        val verbInForm = verbFormInfoMap[currentVerbFormInfo]
            ?: verbFormInfoMap[removeGender(currentVerbFormInfo)] //We need to see undefined gender most of times
            ?: throw Exception("Not found form $currentVerbFormInfo")
        if (verbInForm == "-") {
            throw Exception("This form doesn't exists $currentVerbFormInfo")
        }
        return verbVariantsSplit(verbInForm)
    }

    fun getWorkingTenses(): List<GrammaticalTense> = listOf(
        IndicativePresentTense,
        IndicativeImperfectTense,
        IndicativePreteriteTense,
        IndicativePluperfectTense,
        IndicativeFutureTense,

        SubjunctivePresentTense,
        SubjunctivePreteriteTense,
        SubjunctiveImperfectTense,

        ConditionalTense,
        ImperativeTense,
        InfinitiveTense,
        PersonalInfinitiveTense,
        PastParticipleForSerEstarTense,
        PastParticipleTense,
        GerundTense
    )

    private fun verbVariantsSplit(maybeVerbForms: String): List<String> {
        val forms = maybeVerbForms.split(" - ")
        return forms.map { it.trim() }
    }

    private fun removeGender(verbFormInfo: VerbFormInfo): VerbFormInfo {
        return verbFormInfo.copy(gender = GrammaticalGender.UNDEFINED)
    }

}

