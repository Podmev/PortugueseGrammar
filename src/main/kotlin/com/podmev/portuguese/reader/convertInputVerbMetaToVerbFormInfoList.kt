package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.input.InputVerbMeta

fun convertInputVerbMetaToVerbFormInfoList(inputVerbMeta: InputVerbMeta): List<VerbFormInfo> {
    val conjugations = inputVerbMeta.conjugations ?: return listOf()
    val infinitive = inputVerbMeta.word
    return conjugations.mapNotNull { convertConjugationToVerbFormInfo(it, infinitive) }
}

