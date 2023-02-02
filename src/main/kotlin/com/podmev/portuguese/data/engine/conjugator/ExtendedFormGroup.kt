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
import emptyExtendedPronounVerbForm

data class ExtendedFormGroup(
    val singularFirst: ExtendedPronounVerbForm,
    val singularSecond: ExtendedPronounVerbForm,
    val singularThird: ExtendedPronounVerbForm,
    val pluralFirst: ExtendedPronounVerbForm,
    val pluralSecond: ExtendedPronounVerbForm,
    val pluralThird: ExtendedPronounVerbForm
) {

    fun getDefectiveGroup(portugueseLocale: PortugueseLocale): DefectiveGroup =
        DefectiveGroup(
            singularFirst = !singularFirst.isEmpty(portugueseLocale),
            singularSecond = !singularSecond.isEmpty(portugueseLocale),
            singularThird = !singularThird.isEmpty(portugueseLocale),
            pluralFirst = !pluralFirst.isEmpty(portugueseLocale),
            pluralSecond = !pluralSecond.isEmpty(portugueseLocale),
            pluralThird = !pluralThird.isEmpty(portugueseLocale)
        )

    fun getForm(verbArgs: VerbArguments, portugueseLocale: PortugueseLocale): List<String> =
        getExtendedPronounVerbForm(verbArgs.person, verbArgs.number, portugueseLocale)
            .getVersionsByLocale(portugueseLocale)

    fun getExtendedPronounVerbForm(
        verbArgs: VerbArguments,
        portugueseLocale: PortugueseLocale
    ): ExtendedPronounVerbForm = getExtendedPronounVerbForm(verbArgs.person, verbArgs.number, portugueseLocale)

    fun getExtendedPronounVerbForm(
        person: GrammaticalPerson,
        number: GrammaticalNumber,
        portugueseLocale: PortugueseLocale
    ): ExtendedPronounVerbForm =
        when (number) {
            UNDEFINED -> emptyExtendedPronounVerbForm
            SINGULAR ->
                when (person) {
                    FIRST -> singularFirst
                    SECOND -> singularSecond
                    THIRD -> singularThird
                    GrammaticalPerson.UNDEFINED -> emptyExtendedPronounVerbForm
                }

            PLURAL ->
                when (person) {
                    FIRST -> pluralFirst
                    SECOND -> pluralSecond
                    THIRD -> pluralThird
                    GrammaticalPerson.UNDEFINED -> emptyExtendedPronounVerbForm
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


