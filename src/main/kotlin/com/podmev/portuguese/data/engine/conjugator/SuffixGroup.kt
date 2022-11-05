package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.utils.lang.prepend

data class SuffixGroup(
    val singularFirst: String?,
    val singularSecond: String?,
    val singularThird: String?,
    val pluralFirst: String?,
    val pluralSecond: String?,
    val pluralThird: String?,
    //usually it is not needed to fill, because default suffix has 2 letters
    val droppingSuffixLength: Int = VerbEnds.typicalSize
) {

    fun getSuffix(verbArgs: VerbArguments): String? = getSuffix(verbArgs.person, verbArgs.number)
    fun getSuffix(person: GrammaticalPerson, number: GrammaticalNumber): String? =
        when (number) {
            GrammaticalNumber.UNDEFINED -> ""
            GrammaticalNumber.SINGULAR ->
                when (person) {
                    GrammaticalPerson.FIRST -> singularFirst
                    GrammaticalPerson.SECOND -> singularSecond
                    GrammaticalPerson.THIRD -> singularThird
                    GrammaticalPerson.UNDEFINED -> ""
                }

            GrammaticalNumber.PLURAL ->
                when (person) {
                    GrammaticalPerson.FIRST -> pluralFirst
                    GrammaticalPerson.SECOND -> pluralSecond
                    GrammaticalPerson.THIRD -> pluralThird
                    GrammaticalPerson.UNDEFINED -> ""
                }
        }

    fun extendChar(char: Char): SuffixGroup =
        SuffixGroup(
            singularFirst?.prepend(char),
            singularSecond?.prepend(char),
            singularThird?.prepend(char),
            pluralFirst?.prepend(char),
            pluralSecond?.prepend(char),
            pluralThird?.prepend(char),
            droppingSuffixLength + 1
        )

}
