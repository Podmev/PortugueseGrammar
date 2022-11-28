package com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup
import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

interface ImperativeMoodTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.IMPERATIVE
    override val canHavePerson: Boolean
        get() = true
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = false

    /*really doesn't exist this form in imperative*/
    private val pronounGroupExceptionList: List<PersonalPronounGroup>
        get() = listOf(PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST))

    override fun pronounGroupExceptions(): List<PersonalPronounGroup> = pronounGroupExceptionList
}