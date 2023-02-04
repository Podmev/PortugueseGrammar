package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.UNDEFINED
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

data class ListFormGroup(
    val singularFirst: ListPronounVerbForm?,
    val singularSecond: ListPronounVerbForm?,
    val singularThird: ListPronounVerbForm?,
    val pluralFirst: ListPronounVerbForm?,
    val pluralSecond: ListPronounVerbForm?,
    val pluralThird: ListPronounVerbForm?
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

    fun getForm(verbArgs: VerbArguments): List<String>? =
        getListPronounVerbForm(verbArgs.person, verbArgs.number)?.versions?.toList()

    fun getListPronounVerbForm(
        person: GrammaticalPerson,
        number: GrammaticalNumber
    ): ListPronounVerbForm? =
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

    override fun toString(): String {
        return "ListFormGroup($singularFirst, $singularSecond, $singularThird, $pluralFirst, $pluralSecond, $pluralThird)"
    }

}

fun ListFormGroup.convertToExtended(): ExtendedFormGroup =
    ExtendedFormGroup(
        singularFirst?.toExtended(),
        singularSecond?.toExtended(),
        singularThird?.toExtended(),
        pluralFirst?.toExtended(),
        pluralSecond?.toExtended(),
        pluralThird?.toExtended()
    )


