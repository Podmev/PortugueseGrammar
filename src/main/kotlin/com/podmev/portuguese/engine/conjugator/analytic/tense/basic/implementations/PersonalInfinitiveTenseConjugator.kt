package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator

object PersonalInfinitiveTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> = listOf("$verbInInfinitive${ending(verbArgs.person, verbArgs.number)}")

    private fun ending(person: GrammaticalPerson, number: GrammaticalNumber): String =
        when (number) {
            GrammaticalNumber.UNDEFINED -> ""
            GrammaticalNumber.SINGULAR ->
                when (person) {
                    GrammaticalPerson.FIRST -> ""
                    GrammaticalPerson.SECOND -> "es"
                    GrammaticalPerson.THIRD -> ""
                    GrammaticalPerson.UNDEFINED -> ""
                }

            GrammaticalNumber.PLURAL ->
                when (person) {
                    GrammaticalPerson.FIRST -> "mos"
                    GrammaticalPerson.SECOND -> "des"
                    GrammaticalPerson.THIRD -> "em"
                    GrammaticalPerson.UNDEFINED -> ""
                }
        }

    override fun toString(): String {
        return "PersonalInfinitiveTenseConjugator"
    }
}