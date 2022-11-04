package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

data class BaseGroup(
    val singularFirst: String?,
    val singularSecond: String?,
    val singularThird: String?,
    val pluralFirst: String?,
    val pluralSecond: String?,
    val pluralThird: String?
) {

    fun getBase(verbArgs: VerbArguments): String? = getBase(verbArgs.person, verbArgs.number)
    fun getBase(person: GrammaticalPerson, number: GrammaticalNumber): String? =
        when (number) {
            GrammaticalNumber.UNDEFINED -> ""
            GrammaticalNumber.SINGULAR ->
                when (person) {
                    GrammaticalPerson.FIRST -> singularFirst
                    GrammaticalPerson.SECOND -> singularSecond
                    GrammaticalPerson.THIRD -> singularThird
                    GrammaticalPerson.UNDEFINED -> ""
                }

            GrammaticalNumber.PLURAL ->
                when (person) {
                    GrammaticalPerson.FIRST -> pluralFirst
                    GrammaticalPerson.SECOND -> pluralSecond
                    GrammaticalPerson.THIRD -> pluralThird
                    GrammaticalPerson.UNDEFINED -> ""
                }
        }

    }


