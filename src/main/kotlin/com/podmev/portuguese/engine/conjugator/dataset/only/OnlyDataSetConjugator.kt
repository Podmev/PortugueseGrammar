package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.engine.conjugator.ConjugatorCoveringData
import com.podmev.portuguese.data.engine.conjugator.allConjugationSettingsCombinations
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.AffirmativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.NegativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveImperfectTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePreteriteTense
import com.podmev.portuguese.data.grammar.term.verb.*
import com.podmev.portuguese.data.other.PortugueseLocale
import com.podmev.portuguese.engine.dataset.verb.findInputVerbMeta
import com.podmev.portuguese.engine.dataset.verb.getAllVerbs
import com.podmev.portuguese.reader.convertInputVerbMetaToVerbFormInfoMap

//TODO make custom exceptions
/*uses only dataset, if there is no such tense throws exception*/
object OnlyDataSetConjugator : Conjugator {
    private const val defectivePrefix = "-Normally defective:"
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> {
        val verbMeta =
            findInputVerbMeta(verbInInfinitive) ?: throw Exception("Verb $verbInInfinitive is not found in dataset")
        val verbFormInfoMap: Map<VerbFormInfo, String> = convertInputVerbMetaToVerbFormInfoMap(verbMeta)
        val currentVerbFormInfo = createVerbFormInfoWithVerbArgs(verbInInfinitive, tense, verbArgs, settings)
        val verbInForm = verbFormInfoMap[currentVerbFormInfo]
            ?: verbFormInfoMap[removeGender(currentVerbFormInfo)] //We need to see undefined gender most of times
            ?: throw Exception("Not found form $currentVerbFormInfo")
        if (verbInForm == "-") {
            //It is not valid to throw Exception
            return emptyList()
        }
        if (verbInForm.startsWith(defectivePrefix)) {
            if (settings.ignoreDefective) {
                //so defective anyway
                return listOf(verbInForm.drop(defectivePrefix.length))
            }
            //form doesn't exists for verb
            return emptyList()
        }
        val forms = verbVariantsSplit(verbInForm)
        //special case of difference in locales
        if(tense==IndicativePreteriteTense && verbArgs.isFirstPlural() ){
            return when(settings.portugueseLocale){
                PortugueseLocale.BRAZIL -> forms.take(1)
                PortugueseLocale.PORTUGAL -> forms.drop(1)
            }
        }
        return forms
    }

    fun getConjugatorCoveringData() =
        ConjugatorCoveringData(
            getCoveredVerbs().asSequence(),
            getCoveredTenses().asSequence(),
            listOf(GrammaticalVoice.ACTIVE).asSequence(), //passive is not supported here
            getCoveredSettings().asSequence()
        )

    fun getConjugatorCoveringDataWithFixedTense(tense: GrammaticalTense) =
        ConjugatorCoveringData(
            getCoveredVerbs().asSequence(),
            sequenceOf(tense),
            listOf(GrammaticalVoice.ACTIVE).asSequence(), //passive is not supported here
            getCoveredSettings().asSequence()
        )

    fun getConjugatorCoveringDataWithFixedTenseAndSettings(tense: GrammaticalTense, settings: ConjugateSettings) =
        ConjugatorCoveringData(
            getCoveredVerbs().asSequence(),
            sequenceOf(tense),
            listOf(GrammaticalVoice.ACTIVE).asSequence(), //passive is not supported here
            sequenceOf(settings)
        )

    private fun getCoveredTenses(): List<GrammaticalTense> = listOf(
        IndicativePresentTense,
        IndicativeImperfectTense,
        IndicativePreteriteTense,
        IndicativePluperfectTense,
        IndicativeFutureTense,

        SubjunctivePresentTense,
        SubjunctivePreteriteTense,
        SubjunctiveImperfectTense,

        ConditionalTense,
        AffirmativeImperativeTense,
        NegativeImperativeTense,
        InfinitiveTense,
        PersonalInfinitiveTense,
        PastParticipleForSerEstarTense,
        PastParticipleTense,
        GerundTense
    )

    private fun getCoveredSettings(): List<ConjugateSettings> = allConjugationSettingsCombinations()

    fun getCoveredVerbs(): List<String> =
        getAllVerbs().filter { findInputVerbMeta(it)?.conjugations != null }

    private fun verbVariantsSplit(maybeVerbForms: String): List<String> {
        val forms = maybeVerbForms.split(" - ")
        return forms.map { it.trim() }
    }

    private fun removeGender(verbFormInfo: VerbFormInfo): VerbFormInfo {
        return verbFormInfo.copy(gender = GrammaticalGender.UNDEFINED)
    }

}

