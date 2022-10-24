package com.podmev.portuguese.data.grammar.term.tense

import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

//TODO add next tenses:
//haver: double: separate and in normal tenses
//imperfeito de cortesia - can be with infinitive or noun.
//if it is two verbs it is usually podia, queria, preferia. if it is one - it can be any

//TODO add portuguese name for tense
//TODO description

interface GrammaticalTense{
    val mood: GrammaticalMood
    val canHavePerson: Boolean
    val canHaveNumber: Boolean
    val canHaveGender: Boolean
}