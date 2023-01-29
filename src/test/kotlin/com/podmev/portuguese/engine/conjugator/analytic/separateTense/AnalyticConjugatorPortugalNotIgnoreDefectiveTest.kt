package com.podmev.portuguese.engine.conjugator.analytic.separateTense

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.AffirmativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.NegativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveImperfectTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveFutureTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.other.PortugueseLocale
import com.podmev.portuguese.engine.conjugator.analytic.AnalyticConjugator
import com.podmev.portuguese.engine.conjugator.dataset.only.OnlyDataSetConjugator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


/* same tests as in AnalyticConjugatorCheckByDataSetTest, but separated by unit for each possible grammatical tense
* */
class AnalyticConjugatorPortugalNotIgnoreDefectiveTest {
    @ParameterizedTest
    @MethodSource("allVerbFormsIndicativePresentTense")
    fun indicativePresentTenseTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsIndicativeImperfectTense")
    fun indicativeImperfectTenseTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsIndicativePreteriteTense")
    fun indicativePreteriteTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsIndicativePluperfectTense")
    fun indicativePluperfectTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsIndicativeFutureTense")
    fun indicativeFutureTenseTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsSubjunctivePresentTense")
    fun subjunctivePresentTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsSubjunctiveFutureTense")
    fun subjunctiveFutureTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsSubjunctiveImperfectTense")
    fun subjunctiveImperfectTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsConditionalTense")
    fun conditionalTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsAffirmativeImperativeTense")
    fun affirmativeImperativeTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsNegativeImperativeTense")
    fun negativeImperativeTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsInfinitiveTense")
    fun infinitiveTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsPersonalInfinitiveTense")
    fun personalInfinitiveTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsPastParticipleForSerEstarTense")
    fun pastParticipleForSerEstarTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsPastParticipleTense")
    fun pastParticipleTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    @ParameterizedTest
    @MethodSource("allVerbFormsGerundTense")
    fun gerundTest(verbFormInfo: VerbFormInfo) = checkVerbFormInfo(verbFormInfo)

    private fun checkVerbFormInfo(data: VerbFormInfo) {
        val verbArgs = VerbArguments(
            person = data.person,
            number = data.number,
            gender = data.gender,
            voice = data.voice
        )
        Assertions.assertEquals(
            OnlyDataSetConjugator.conjugateVerb(
                verbInInfinitive = data.infinitive,
                tense = data.tense,
                verbArgs = verbArgs,
                settings = data.settings
            ), AnalyticConjugator.conjugateVerb(
                verbInInfinitive = data.infinitive,
                tense = data.tense,
                verbArgs = verbArgs,
                settings = data.settings
            ), "Combination: $data"
        )
    }

    companion object {
        /*unique difference*/
        private val settings = ConjugateSettings(false, PortugueseLocale.PORTUGAL)

        @JvmStatic
        fun allVerbFormsIndicativePresentTense() = verbFormInfosByTense(IndicativePresentTense)

        @JvmStatic
        fun allVerbFormsIndicativeImperfectTense() = verbFormInfosByTense(IndicativeImperfectTense)

        @JvmStatic
        fun allVerbFormsIndicativePreteriteTense() = verbFormInfosByTense(IndicativePreteriteTense)

        @JvmStatic
        fun allVerbFormsIndicativePluperfectTense() = verbFormInfosByTense(IndicativePluperfectTense)

        @JvmStatic
        fun allVerbFormsIndicativeFutureTense() = verbFormInfosByTense(IndicativeFutureTense)

        @JvmStatic
        fun allVerbFormsSubjunctivePresentTense() = verbFormInfosByTense(SubjunctivePresentTense)

        @JvmStatic
        fun allVerbFormsSubjunctiveFutureTense() = verbFormInfosByTense(SubjunctiveFutureTense)

        @JvmStatic
        fun allVerbFormsSubjunctiveImperfectTense() = verbFormInfosByTense(SubjunctiveImperfectTense)

        @JvmStatic
        fun allVerbFormsConditionalTense() = verbFormInfosByTense(ConditionalTense)

        @JvmStatic
        fun allVerbFormsAffirmativeImperativeTense() = verbFormInfosByTense(AffirmativeImperativeTense)

        @JvmStatic
        fun allVerbFormsNegativeImperativeTense() = verbFormInfosByTense(NegativeImperativeTense)

        @JvmStatic
        fun allVerbFormsInfinitiveTense() = verbFormInfosByTense(InfinitiveTense)

        @JvmStatic
        fun allVerbFormsPersonalInfinitiveTense() = verbFormInfosByTense(PersonalInfinitiveTense)

        @JvmStatic
        fun allVerbFormsPastParticipleForSerEstarTense() = verbFormInfosByTense(PastParticipleForSerEstarTense)

        @JvmStatic
        fun allVerbFormsPastParticipleTense() = verbFormInfosByTense(PastParticipleTense)

        @JvmStatic
        fun allVerbFormsGerundTense() = verbFormInfosByTense(GerundTense)

        private fun verbFormInfosByTense(tense: GrammaticalTense) =
            OnlyDataSetConjugator.getConjugatorCoveringDataWithFixedTenseAndSettings(tense, settings)
                .getAllVerbFormInfos()
    }
}