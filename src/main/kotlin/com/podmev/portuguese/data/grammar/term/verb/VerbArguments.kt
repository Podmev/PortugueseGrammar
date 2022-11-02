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

fun VerbArguments.isSecondSingular(): Boolean =
    person == GrammaticalPerson.SECOND && number == GrammaticalNumber.SINGULAR

fun VerbArguments.isThirdSingular(): Boolean =
    person == GrammaticalPerson.THIRD && number == GrammaticalNumber.SINGULAR

fun VerbArguments.isFirstPlural(): Boolean =
    person == GrammaticalPerson.FIRST && number == GrammaticalNumber.PLURAL

fun VerbArguments.isSecondPlural(): Boolean =
    person == GrammaticalPerson.SECOND && number == GrammaticalNumber.PLURAL

fun VerbArguments.isThirdPlural(): Boolean =
    person == GrammaticalPerson.THIRD && number == GrammaticalNumber.PLURAL

fun VerbArguments.isFirst(): Boolean =
    person == GrammaticalPerson.FIRST

fun VerbArguments.isSecond(): Boolean =
    person == GrammaticalPerson.SECOND

fun VerbArguments.isThird(): Boolean =
    person == GrammaticalPerson.THIRD

fun VerbArguments.isSingular(): Boolean =
    number == GrammaticalNumber.SINGULAR

fun VerbArguments.isPlural(): Boolean =
    number == GrammaticalNumber.PLURAL
