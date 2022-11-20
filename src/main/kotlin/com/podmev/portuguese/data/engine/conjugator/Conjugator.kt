package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

interface Conjugator {

    /*conjugate verb according to given tense and arguments
    * usually result is one form. if form doesn't exist, so it will be empty list
    * In some rare cases it can be more than one option of form
    * */
    fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String>

    fun conjugateVerbInFormGroup(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        gender: GrammaticalGender,
        voice: GrammaticalVoice,
        settings: ConjugateSettings
    ): FormGroup {
        fun byPersonNumber(person: GrammaticalPerson, number: GrammaticalNumber):String? =
            conjugateVerb(
                verbInInfinitive = verbInInfinitive,
                tense = tense,
                verbArgs = VerbArguments(person, number, gender, voice),
                settings = settings
            ).firstOrNull()

        return FormGroup(
            singularFirst = byPersonNumber(FIRST, SINGULAR),
            singularSecond = byPersonNumber(SECOND, SINGULAR),
            singularThird = byPersonNumber(THIRD, SINGULAR),
            pluralFirst = byPersonNumber(FIRST, PLURAL),
            pluralSecond = byPersonNumber(SECOND, PLURAL),
            pluralThird = byPersonNumber(THIRD, PLURAL)
        )
    }
}