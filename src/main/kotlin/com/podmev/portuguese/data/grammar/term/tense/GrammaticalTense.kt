package com.podmev.portuguese.data.grammar.term.tense

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

//TODO add next tenses:
//haver: double: separate and in normal tenses
//imperfeito de cortesia - can be with infinitive or noun.
//if it is two verbs it is usually podia, queria, preferia. if it is one - it can be any

//TODO add portuguese name for tense
//TODO description
//TODO canHaveVoice

interface GrammaticalTense {
    val mood: GrammaticalMood
    val canHavePerson: Boolean
    val canHaveNumber: Boolean
    val canHaveGender: Boolean

    fun possiblePersons(): Sequence<GrammaticalPerson> = GrammaticalPerson.getDefinedList(canHavePerson).asSequence()
    fun possibleNumbers(): Sequence<GrammaticalNumber> = GrammaticalNumber.getDefinedList(canHaveNumber).asSequence()
    fun possibleGenders(): Sequence<GrammaticalGender> = GrammaticalGender.getDefinedList(canHaveGender).asSequence()

    /*empty for almost all tenses, except for imperative*/
    fun pronounGroupExceptions(): List<PersonalPronounGroup> = emptyList()

    fun possiblePronounGroups(): Sequence<PersonalPronounGroup> =
        possiblePersons().flatMap {
            person->possibleNumbers().map { PersonalPronounGroup(it, person)  }
        }.filter { it !in pronounGroupExceptions() }
}