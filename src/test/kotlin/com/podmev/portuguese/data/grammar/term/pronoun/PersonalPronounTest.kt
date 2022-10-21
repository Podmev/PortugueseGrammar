package com.podmev.portuguese.data.grammar.term.pronoun

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import io.quarkus.test.junit.QuarkusTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PersonalPronounTest {
    @Test
    fun singularTest() {
        assertEquals(
            "All singular pronouns",
            setOf(
                PronounEu,
                PronounTu,
                PronounVoce,
                PronounEle,
                PronounEla,
                PronounSenhor,
                PronounSenhora
            ),
            allPersonalPronouns()
                .filter { it.pronounGroup.grammaticalNumber == GrammaticalNumber.SINGULAR }
                .toSet()
        )
    }

    @Test
    fun pluralTest() {
        assertEquals(
            "All plural pronouns",
            setOf(
                PronounNos,
                PronounVoces,
                PronounEles,
                PronounElas,
                PronounSenhores,
                PronounSenhoras,
                PronounVos
            ),
            allPersonalPronouns()
                .filter { it.pronounGroup.grammaticalNumber == GrammaticalNumber.PLURAL }
                .toSet()
        )
    }

    @Test
    fun noGenderTest() {
        assertEquals(
            "All pronouns without gender",
            setOf(
                PronounEu,
                PronounTu,
                PronounVoce,
                PronounNos,
                PronounVoces,
                PronounVos
            ),
            allPersonalPronouns()
                .filter { it.gender == GrammaticalGender.UNDEFINED }
                .toSet()
        )
    }

    @Test
    fun masculineGenderTest() {
        assertEquals(
            "All masculine pronouns",
            setOf(
                PronounEle,
                PronounSenhor,
                PronounEles,
                PronounSenhores
            ),
            allPersonalPronouns()
                .filter { it.gender == GrammaticalGender.MASCULINE }
                .toSet()
        )
    }

    @Test
    fun feminineGenderTest() {
        assertEquals(
            "All feminine pronouns",
            setOf(
                PronounEla,
                PronounSenhora,
                PronounElas,
                PronounSenhoras
            ),
            allPersonalPronouns()
                .filter { it.gender == GrammaticalGender.FEMININE }
                .toSet()
        )
    }

    @Test
    fun firstPersonTest() {
        assertEquals(
            "All first person pronouns",
            setOf(
                PronounEu,
                PronounNos
            ),
            allPersonalPronouns()
                .filter { it.pronounGroup.grammaticalPerson == GrammaticalPerson.FIRST }
                .toSet()
        )
    }

    @Test
    fun secondPersonTest() {
        assertEquals(
            "All second person pronouns",
            setOf(
                PronounTu,
                PronounVos
            ),
            allPersonalPronouns()
                .filter { it.pronounGroup.grammaticalPerson == GrammaticalPerson.SECOND }
                .toSet()
        )
    }

    @Test
    fun thirdPersonTest() {
        assertEquals(
            "All third person pronouns",
            setOf(
                PronounVoce,
                PronounEle,
                PronounEla,
                PronounSenhor,
                PronounSenhora,
                PronounVoces,
                PronounEles,
                PronounElas,
                PronounSenhores,
                PronounSenhoras
            ),
            allPersonalPronouns()
                .filter { it.pronounGroup.grammaticalPerson == GrammaticalPerson.THIRD }
                .toSet()
        )
    }
}