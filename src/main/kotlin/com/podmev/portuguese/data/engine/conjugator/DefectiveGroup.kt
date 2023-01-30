package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.UNDEFINED
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

data class DefectiveGroup(
    val singularFirst: Boolean,
    val singularSecond: Boolean,
    val singularThird: Boolean,
    val pluralFirst: Boolean,
    val pluralSecond: Boolean,
    val pluralThird: Boolean
) {
    override fun toString(): String {
        return "DefectiveGroup($singularFirst, $singularSecond, $singularThird, $pluralFirst, $pluralSecond, $pluralThird)"
    }

    fun hasForm(verbArgs: VerbArguments): Boolean? = hasForm(verbArgs.person, verbArgs.number)
    fun hasForm(person: GrammaticalPerson, number: GrammaticalNumber): Boolean? =
        when (number) {
            UNDEFINED -> null
            SINGULAR ->
                when (person) {
                    FIRST -> singularFirst
                    SECOND -> singularSecond
                    THIRD -> singularThird
                    GrammaticalPerson.UNDEFINED -> null
                }

            PLURAL ->
                when (person) {
                    FIRST -> pluralFirst
                    SECOND -> pluralSecond
                    THIRD -> pluralThird
                    GrammaticalPerson.UNDEFINED -> null
                }
        }
}

val falseDefectiveGroup by lazy {
    DefectiveGroup(
        singularFirst = false,
        singularSecond = false,
        singularThird = false,
        pluralFirst = false,
        pluralSecond = false,
        pluralThird = false
    )
}

val trueDefectiveGroup by lazy {
    DefectiveGroup(
        singularFirst = true,
        singularSecond = true,
        singularThird = true,
        pluralFirst = true,
        pluralSecond = true,
        pluralThird = true
    )
}


