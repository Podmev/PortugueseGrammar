package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.engine.conjugator.dataset.only.OnlyDataSetConjugator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


/* 373168 cases by using data set
* */
class AnalyticConjugatorCheckByDataSetTest {

    @ParameterizedTest
    @MethodSource("allVerbForms")
    fun parametrizedTest(verbFormInfo: VerbFormInfo) {
        val verbArgs = VerbArguments(
            person = verbFormInfo.person,
            number = verbFormInfo.number,
            gender = verbFormInfo.gender,
            voice = verbFormInfo.voice
        )
        Assertions.assertEquals(
            OnlyDataSetConjugator.conjugateVerb(
                verbInInfinitive = verbFormInfo.infinitive,
                tense = verbFormInfo.tense,
                verbArgs = verbArgs,
                settings = verbFormInfo.settings
            ), AnalyticConjugator.conjugateVerb(
                verbInInfinitive = verbFormInfo.infinitive,
                tense = verbFormInfo.tense,
                verbArgs = verbArgs,
                settings = verbFormInfo.settings
            ), "Combination: $verbFormInfo"
        )
    }

    companion object {
        @JvmStatic
        fun allVerbForms(): Iterable<VerbFormInfo> {
            val conjugator = OnlyDataSetConjugator
            val coveringData = conjugator.getConjugatorCoveringData()
            return coveringData.getAllVerbFormInfos()
        }
    }
}