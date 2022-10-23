package com.podmev.portuguese.data.grammar.term.verb

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
)

fun createVerbFormInfoWithVerbArgs(
    infinitive: String,
    tense: GrammaticalTense,
    verbArgs: VerbArguments
): VerbFormInfo =
    VerbFormInfo(
        infinitive = infinitive,
        tense = tense,
        person = verbArgs.person,
        number = verbArgs.number,
        gender = verbArgs.gender,
        voice = verbArgs.voice
    )
