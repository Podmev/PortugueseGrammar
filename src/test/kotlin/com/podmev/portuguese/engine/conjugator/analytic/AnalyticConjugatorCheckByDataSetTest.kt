package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.engine.conjugator.dataset.only.OnlyDataSetConjugator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

//todo maybe transform tests into several by tenses

/* 373168 cases by using data set
* */
class AnalyticConjugatorCheckByDataSetTest {
    private val onlyDataSetConjugator = OnlyDataSetConjugator
    private val analyticConjugator = OnlyDataSetConjugator

    @ParameterizedTest
    @MethodSource("allVerbForms")
    fun parametrizedTest(data: VerbFormInfo) {
        val verbArgs = VerbArguments(
            person = data.person,
            number = data.number,
            gender = data.gender,
            voice = data.voice
        )
        Assertions.assertEquals(
            onlyDataSetConjugator.conjugateVerb(
                verbInInfinitive = data.infinitive,
                tense = data.tense,
                verbArgs = verbArgs
            ), analyticConjugator.conjugateVerb(
                verbInInfinitive = data.infinitive,
                tense = data.tense,
                verbArgs = verbArgs
            ), "Combination: $data"
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