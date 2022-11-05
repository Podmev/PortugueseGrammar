package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.UNDEFINED
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

data class FormGroup(
    val singularFirst: String?,
    val singularSecond: String?,
    val singularThird: String?,
    val pluralFirst: String?,
    val pluralSecond: String?,
    val pluralThird: String?
) {

    fun getDefectiveGroup(): DefectiveGroup =
        DefectiveGroup(
            singularFirst = singularFirst != null,
            singularSecond = singularSecond != null,
            singularThird = singularThird != null,
            pluralFirst = pluralFirst != null,
            pluralSecond = pluralSecond != null,
            pluralThird = pluralThird != null
        )

    fun getForm(verbArgs: VerbArguments): String? = getForm(verbArgs.person, verbArgs.number)
    fun getForm(person: GrammaticalPerson, number: GrammaticalNumber): String? =
        when (number) {
            UNDEFINED -> ""
            SINGULAR ->
                when (person) {
                    FIRST -> singularFirst
                    SECOND -> singularSecond
                    THIRD -> singularThird
                    GrammaticalPerson.UNDEFINED -> ""
                }

            PLURAL ->
                when (person) {
                    FIRST -> pluralFirst
                    SECOND -> pluralSecond
                    THIRD -> pluralThird
                    GrammaticalPerson.UNDEFINED -> ""
                }
        }

    override fun toString(): String {
        return "FormGroup($singularFirst, $singularSecond, $singularThird, $pluralFirst, $pluralSecond, $pluralThird)"
    }

}


