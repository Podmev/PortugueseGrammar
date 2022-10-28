package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.GerundTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.InfinitiveTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativeImperfectTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        Assertions.assertEquals(
            /* expected = */ listOf("estava"),
            /* actual = */ verbInForm,
            /* message = */ "Verb 'estar' in indicative imperfect for third person singular, masculine, active"
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
        Assertions.assertEquals(
            /* expected = */ listOf("estar"),
            /* actual = */ verbInForm,
            /* message = */ "Verb 'estar' in infinitive"
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
        Assertions.assertEquals(
            /* expected = */ listOf("fazendo"),
            /* actual = */ verbInForm,
            /* message = */ "Verb 'fazer' in gerund"
        )
    }
}