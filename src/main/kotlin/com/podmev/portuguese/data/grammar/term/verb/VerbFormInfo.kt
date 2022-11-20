package com.podmev.portuguese.data.grammar.term.verb

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class VerbFormInfo(
    val infinitive: String,
    val tense: GrammaticalTense,
    val person: GrammaticalPerson,
    val number: GrammaticalNumber,
    val gender: GrammaticalGender,
    val voice: GrammaticalVoice,
    val settings: ConjugateSettings
){
    fun getVerbArgs(): VerbArguments =
        VerbArguments(person, number, gender, voice)
}

fun createVerbFormInfoWithVerbArgs(
    infinitive: String,
    tense: GrammaticalTense,
    verbArgs: VerbArguments,
    settings: ConjugateSettings
): VerbFormInfo =
    VerbFormInfo(
        infinitive = infinitive,
        tense = tense,
        person = verbArgs.person,
        number = verbArgs.number,
        gender = verbArgs.gender,
        voice = verbArgs.voice,
        settings = settings
    )
