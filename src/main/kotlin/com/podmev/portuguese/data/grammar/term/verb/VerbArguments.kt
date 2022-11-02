package com.podmev.portuguese.data.grammar.term.verb

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson

//TODO think about changing name
//TODO do we need to add affirmative, negative, question here?

/* using tense + VerbArguments we can get final conjugation verb form*/
data class VerbArguments(
    val person: GrammaticalPerson,
    val number: GrammaticalNumber,
    val gender: GrammaticalGender,
    val voice: GrammaticalVoice
)

fun VerbArguments.isFirstSingular(): Boolean =
    person == GrammaticalPerson.FIRST && number == GrammaticalNumber.SINGULAR
