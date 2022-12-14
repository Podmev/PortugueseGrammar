package com.podmev.portuguese.reader

import com.podmev.portuguese.data.engine.conjugator.allConjugationSettingsCombinations
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.input.Conjugation

fun convertConjugationToVerbFormInfo(conjugation: Conjugation, infinitive: String): List<VerbFormInfo> {
    val pronounGroup = parsePersonalPronounGroup(conjugation.form) ?: return emptyList()
    val person = pronounGroup.grammaticalPerson
    val number = pronounGroup.grammaticalNumber
    val gender = parseGenderByTenseShortName(conjugation.group)
    val tenses = parseTenseByShortName(conjugation.group)
    val voice = GrammaticalVoice.ACTIVE //in dataset everything is in active voice
    val infoList = mutableListOf<VerbFormInfo>()
    val settingsCombination = allConjugationSettingsCombinations()
    for (tense in tenses) {
        for (settings in settingsCombination) {
            infoList.add(
                VerbFormInfo(
                    infinitive = infinitive,
                    tense = tense,
                    person = person,
                    number = number,
                    gender = gender,
                    voice = voice,
                    settings = settings
                )
            )
        }
    }
    return infoList
}