package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.input.InputVerbMeta

fun convertInputVerbMetaToVerbFormInfoMap(inputVerbMeta: InputVerbMeta): Map<VerbFormInfo, String> {
    val conjugations = inputVerbMeta.conjugations ?: return emptyMap()
    val infinitive = inputVerbMeta.word
    val resultMap = mutableMapOf<VerbFormInfo, String>()
    for(conjugation in conjugations){
        val verbFormInfo = convertConjugationToVerbFormInfo(conjugation, infinitive) ?: continue
        val verbFormValue = conjugation.value
        resultMap[verbFormInfo] = verbFormValue
    }
    return resultMap
}

