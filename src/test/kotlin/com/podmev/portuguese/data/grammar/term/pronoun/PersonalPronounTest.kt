package com.podmev.portuguese.data.grammar.term.pronoun

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PersonalPronounTest {
    @Test
    fun singularTest() {
        Assertions.assertEquals(setOf(
            PronounEu,
            PronounTu,
            PronounVoce,
            PronounEle,
            PronounEla,
            PronounGente,
            PronounSenhor,
            PronounSenhora
        ), allPersonalPronouns()
            .filter { it.pronounGroup.grammaticalNumber == GrammaticalNumber.SINGULAR }
            .toSet(), "All singular pronouns")
    }

    @Test
    fun pluralTest() {
        Assertions.assertEquals(setOf(
            PronounNos,
            PronounVoces,
            PronounEles,
            PronounElas,
            PronounSenhores,
            PronounSenhoras,
            PronounVos
        ), allPersonalPronouns()
            .filter { it.pronounGroup.grammaticalNumber == GrammaticalNumber.PLURAL }
            .toSet(), "All plural pronouns")
    }

    @Test
    fun noGenderTest() {
        Assertions.assertEquals(setOf(
            PronounEu,
            PronounTu,
            PronounVoce,
            PronounNos,
            PronounGente,
            PronounVoces,
            PronounVos
        ), allPersonalPronouns()
            .filter { it.gender == GrammaticalGender.UNDEFINED }
            .toSet(), "All pronouns without gender")
    }

    @Test
    fun masculineGenderTest() {
        Assertions.assertEquals(setOf(
            PronounEle,
            PronounSenhor,
            PronounEles,
            PronounSenhores
        ), allPersonalPronouns()
            .filter { it.gender == GrammaticalGender.MASCULINE }
            .toSet(), "All masculine pronouns")
    }

    @Test
    fun feminineGenderTest() {
        Assertions.assertEquals(setOf(
            PronounEla,
            PronounSenhora,
            PronounElas,
            PronounSenhoras
        ), allPersonalPronouns()
            .filter { it.gender == GrammaticalGender.FEMININE }
            .toSet(), "All feminine pronouns")
    }

    @Test
    fun firstPersonTest() {
        Assertions.assertEquals(setOf(
            PronounEu,
            PronounNos
        ), allPersonalPronouns()
            .filter { it.pronounGroup.grammaticalPerson == GrammaticalPerson.FIRST }
            .toSet(), "All first person pronouns")
    }

    @Test
    fun secondPersonTest() {
        Assertions.assertEquals(setOf(
            PronounTu,
            PronounVos
        ), allPersonalPronouns()
            .filter { it.pronounGroup.grammaticalPerson == GrammaticalPerson.SECOND }
            .toSet(), "All second person pronouns")
    }

    @Test
    fun thirdPersonTest() {
        Assertions.assertEquals(setOf(
            PronounVoce,
            PronounEle,
            PronounEla,
            PronounGente,
            PronounSenhor,
            PronounSenhora,
            PronounVoces,
            PronounEles,
            PronounElas,
            PronounSenhores,
            PronounSenhoras
        ), allPersonalPronouns()
            .filter { it.pronounGroup.grammaticalPerson == GrammaticalPerson.THIRD }
            .toSet(), "All third person pronouns")
    }
}