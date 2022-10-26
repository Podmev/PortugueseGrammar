package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/*373168 cases, 6 minutes
* */
class OnlyDataSetConjugatorParameterizedTest {
    private val conjugator = OnlyDataSetConjugator

    @ParameterizedTest
    @MethodSource("testDataCollection")
    fun parametrizedTest(data: VerbFormInfo) {
        assertDoesNotThrow("Combination: $data") {
            conjugator.conjugateVerb(
                verbInInfinitive = data.infinitive,
                tense = data.tense,
                verbArgs = VerbArguments(
                    person = data.person,
                    number = data.number,
                    gender = data.gender,
                    voice = data.voice
                )
            )
        }
    }
    companion object {
        @JvmStatic
        fun testDataCollection(): Iterable<VerbFormInfo> {
            val conjugator = OnlyDataSetConjugator
            val coveringData = conjugator.getConjugatorCoveringData()
            return coveringData.getAllVerbFormInfos()
        }
    }
}