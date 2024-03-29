package com.podmev.portuguese.data.engine.conjugator

import ExtendedPronounVerbForm
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.UNDEFINED
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.other.PortugueseLocale
import createExtendedFormGroupByString

data class ExtendedFormGroup(
    val singularFirst: ExtendedPronounVerbForm?,
    val singularSecond: ExtendedPronounVerbForm?,
    val singularThird: ExtendedPronounVerbForm?,
    val pluralFirst: ExtendedPronounVerbForm?,
    val pluralSecond: ExtendedPronounVerbForm?,
    val pluralThird: ExtendedPronounVerbForm?
) {

    fun getDefectiveGroup(portugueseLocale: PortugueseLocale): DefectiveGroup =
        DefectiveGroup(
            singularFirst = singularFirst != null,
            singularSecond = singularSecond != null,
            singularThird = singularThird != null,
            pluralFirst = pluralFirst != null,
            pluralSecond = pluralSecond != null,
            pluralThird = pluralThird != null
        )

    fun getForm(verbArgs: VerbArguments, portugueseLocale: PortugueseLocale): List<String>? =
        getExtendedPronounVerbForm(verbArgs.person, verbArgs.number)
            ?.getVersionsByLocale(portugueseLocale)

    fun getExtendedPronounVerbForm(
        person: GrammaticalPerson,
        number: GrammaticalNumber,
    ): ExtendedPronounVerbForm? =
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
        return "ExtendedFormGroup($singularFirst, $singularSecond, $singularThird, $pluralFirst, $pluralSecond, $pluralThird)"
    }

}

fun FormGroup.convertToExtended():ExtendedFormGroup =
    ExtendedFormGroup(
        createExtendedFormGroupByString(singularFirst),
        createExtendedFormGroupByString(singularSecond),
        createExtendedFormGroupByString(singularThird),
        createExtendedFormGroupByString(pluralFirst),
        createExtendedFormGroupByString(pluralSecond),
        createExtendedFormGroupByString(pluralThird),
    )


