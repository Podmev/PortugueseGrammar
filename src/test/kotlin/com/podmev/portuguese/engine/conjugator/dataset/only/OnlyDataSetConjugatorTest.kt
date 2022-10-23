package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativeImperfectTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import org.junit.Assert.assertEquals
import org.junit.Test

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
}