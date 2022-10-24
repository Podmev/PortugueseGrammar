package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.GerundTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.InfinitiveTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativeImperfectTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow

class OnlyDataSetConjugatorTest {
    private val conjugator = OnlyDataSetConjugator

    @Test
    fun estarImperfectThirdPersonSingularMasculineTest() {
        val verbInForm: List<String> = conjugator.conjugateVerb(
            verbInInfinitive = "estar",
            tense = IndicativeImperfectTense,
            verbArgs = VerbArguments(
                person = GrammaticalPerson.THIRD,
                number = GrammaticalNumber.SINGULAR,
                gender = GrammaticalGender.MASCULINE,
                voice = GrammaticalVoice.ACTIVE
            )
        )
        assertEquals(
            /* message = */ "Verb 'estar' in indicative imperfect for third person singular, masculine, active",
            /* expected = */ listOf("estava"),
            /* actual = */  verbInForm
        )
    }

    @Test
    fun estarInfinitiveTest() {
        val verbInForm: List<String> = conjugator.conjugateVerb(
            verbInInfinitive = "estar",
            tense = InfinitiveTense,
            verbArgs = VerbArguments(
                person = GrammaticalPerson.UNDEFINED,
                number = GrammaticalNumber.UNDEFINED,
                gender = GrammaticalGender.UNDEFINED,
                voice = GrammaticalVoice.ACTIVE
            )
        )
        assertEquals(
            /* message = */ "Verb 'estar' in infinitive",
            /* expected = */ listOf("estar"),
            /* actual = */  verbInForm
        )
    }

    @Test
    fun fazerGerundTest() {
        val verbInForm: List<String> = conjugator.conjugateVerb(
            verbInInfinitive = "fazer",
            tense = GerundTense,
            verbArgs = VerbArguments(
                person = GrammaticalPerson.UNDEFINED,
                number = GrammaticalNumber.UNDEFINED,
                gender = GrammaticalGender.UNDEFINED,
                voice = GrammaticalVoice.ACTIVE
            )
        )
        assertEquals(
            /* message = */ "Verb 'fazer' in gerund",
            /* expected = */ listOf("fazendo"),
            /* actual = */  verbInForm
        )
    }

    //TODO fix test - more intellectual getting person and maybe number
    /*long test - cartesian params for all verbs*/
    @Test
    @Ignore("wrong")
    fun allExistingCombinationsTest() {
        val coveringData = conjugator.getConjugatorCoveringData()
        //TODO refactor with ConjugatorCoveringData.getAllVerbFormInfos
        for (verb in coveringData.verbInfinitives) {
            for (tense in coveringData.tenses) {
                for (person in coveringData.persons) {
                    for (number in coveringData.numbers) {
                        for (gender in coveringData.genders) {
                            for (voice in coveringData.voices) {
                                assertDoesNotThrow("Combination: $verb, $tense, $person, $number, $gender, $voice") {
                                    val verbInForm: List<String> = conjugator.conjugateVerb(
                                        verbInInfinitive = verb,
                                        tense = tense,
                                        verbArgs = VerbArguments(
                                            person = person,
                                            number = number,
                                            gender = gender,
                                            voice = voice
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}