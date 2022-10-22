package com.podmev.portuguese.data.grammar.term.verb

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class VerbFormInfo(
    val tense: GrammaticalTense,
    val person: GrammaticalPerson,
    val number: GrammaticalNumber,
    val voice: GrammaticalVoice,
)
