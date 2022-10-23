package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ParsePersonalPronounGroupTest {
    @Test
    fun emptyTest(){
        assertEquals(
            "Empty string",
            PersonalPronounGroup(GrammaticalNumber.UNDEFINED, GrammaticalPerson.UNDEFINED),
            parsePersonalPronounGroup("")
        )
    }

    @Test
    fun singularFirstTest(){
        assertEquals(
            "Singular first person s1",
            PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST),
            parsePersonalPronounGroup("s1")
        )
    }

    @Test
    fun singularSecondTest(){
        assertEquals(
            "Singular second person s2",
            PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.SECOND),
            parsePersonalPronounGroup("s2")
        )
    }

    @Test
    fun singularThirdTest(){
        assertEquals(
            "Singular third person s3",
            PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD),
            parsePersonalPronounGroup("s3")
        )
    }

    @Test
    fun singularUndefinedTest(){
        assertEquals(
            "Singular undefined person s",
            PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.UNDEFINED),
            parsePersonalPronounGroup("s")
        )
    }

    @Test
    fun pluralFirstTest(){
        assertEquals(
            "Plural first person p1",
            PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.FIRST),
            parsePersonalPronounGroup("p1")
        )
    }

    @Test
    fun pluralSecondTest(){
        assertEquals(
            "Plural second person p2",
            PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.SECOND),
            parsePersonalPronounGroup("p2")
        )
    }

    @Test
    fun pluralThirdTest(){
        assertEquals(
            "Plural third person p3",
            PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD),
            parsePersonalPronounGroup("p3")
        )
    }

    @Test
    fun pluralUndefinedTest(){
        assertEquals(
            "Plural undefined person p",
            PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.UNDEFINED),
            parsePersonalPronounGroup("p")
        )
    }





    //Negative tests
    @Test
    fun negativeThreeSymbolsTest(){
        assertEquals(
            "Three symbols abc",
            null,
            parsePersonalPronounGroup("abc")
        )
    }

    @Test
    fun negativeSingularZeroTest(){
        assertEquals(
            "singular zero",
            null,
            parsePersonalPronounGroup("s0")
        )
    }

    @Test
    fun negativePluralZeroTest(){
        assertEquals(
            "plural zero",
            null,
            parsePersonalPronounGroup("p0")
        )
    }

    @Test
    fun negativeSingular4Test(){
        assertEquals(
            "singular 4",
            null,
            parsePersonalPronounGroup("s4")
        )
    }

    @Test
    fun negativePlural4Test(){
        assertEquals(
            "plural 4",
            null,
            parsePersonalPronounGroup("p4")
        )
    }

    @Test
    fun negativeOtherLetter2Test(){
        assertEquals(
            "other letter 2",
            null,
            parsePersonalPronounGroup("r2")
        )
    }
}