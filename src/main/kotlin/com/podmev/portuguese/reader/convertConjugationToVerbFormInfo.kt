package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.input.Conjugation

fun convertConjugationToVerbFormInfo(conjugation: Conjugation, infinitive: String): VerbFormInfo? {
    val pronounGroup = parsePersonalPronounGroup(conjugation.form) ?: return null
    val gender = parseGenderByTenseShortName(conjugation.group)
    val tense = parseTenseByShortName(conjugation.group) ?: return null
    val voice = GrammaticalVoice.ACTIVE //in dataset everything is in active voice
    return VerbFormInfo(
        infinitive = infinitive,
        tense = tense,
        person = pronounGroup.grammaticalPerson,
        number = pronounGroup.grammaticalNumber,
        gender = gender,
        voice = voice
    )
}