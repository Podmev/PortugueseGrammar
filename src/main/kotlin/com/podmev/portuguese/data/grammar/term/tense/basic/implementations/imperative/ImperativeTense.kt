package com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup
import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

/*Note: there is affirmative and negative version, but there is no need to use in model*/
object ImperativeTense : BasicTense {
    override val mood: GrammaticalMood
        get() = GrammaticalMood.IMPERATIVE
    override val canHavePerson: Boolean
        get() = true
    override val canHaveNumber: Boolean
        get() = true
    override val canHaveGender: Boolean
        get() = true

    /*really doesn't exist this form in imperative*/
    private val pronounGroupExceptionList =
        listOf(PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST))

    override fun pronounGroupExceptions(): List<PersonalPronounGroup> = pronounGroupExceptionList

    override fun toString(): String {
        return "ImperativeTense"
    }
}