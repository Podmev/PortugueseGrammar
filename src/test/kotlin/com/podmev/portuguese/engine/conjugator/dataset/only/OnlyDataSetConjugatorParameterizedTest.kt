package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/*373168 cases
 18 minutes
 225 are failed
* */
class OnlyDataSetConjugatorParameterizedTest {
    private val conjugator = OnlyDataSetConjugator

    @ParameterizedTest
    @MethodSource("testDataCollection")
    fun parametrizedTest(data: TestData) {
        assertDoesNotThrow("Combination: $data") {
            conjugator.conjugateVerb(
                verbInInfinitive = data.verb,
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

    data class TestData(
        val verb: String,
        val tense: GrammaticalTense,
        val person: GrammaticalPerson,
        val number: GrammaticalNumber,
        val gender: GrammaticalGender,
        val voice: GrammaticalVoice
    )

    companion object {
        @JvmStatic
        fun testDataCollection(): Iterable<TestData> {
            val conjugator = OnlyDataSetConjugator
            val coveringData = conjugator.getConjugatorCoveringData()
            return coveringData.verbInfinitives.flatMap { verb ->
                coveringData.tenses.flatMap { tense ->
                    tense.possiblePronounGroups().flatMap { pronounGroup: PersonalPronounGroup ->
                        tense.possibleGenders().flatMap { gender ->
                            coveringData.voices.map { voice ->
                                TestData(
                                    verb,
                                    tense,
                                    pronounGroup.grammaticalPerson,
                                    pronounGroup.grammaticalNumber,
                                    gender,
                                    voice
                                )
                            }
                        }
                    }
                }
            }.asIterable()
        }
    }
}