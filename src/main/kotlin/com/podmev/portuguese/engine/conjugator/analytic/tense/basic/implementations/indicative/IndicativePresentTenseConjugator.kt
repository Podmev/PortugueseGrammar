package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.UNDEFINED
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.utils.verb.VerbEnds

object IndicativePresentTenseConjugator : IndicativeMoodTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        //TODO add exceptions
        val regularForm = regularChanging(verbInInfinitive, verbArgs)
        return listOf(regularForm)
    }

    private fun regularChanging(verb: String, verbArgs: VerbArguments): String {
        val suffix = getSuffixGroup(verb)!!.getSuffix(verbArgs)
        val preparedBase = prepareBase(verb, suffix)
        return preparedBase + suffix
    }

    private fun prepareBase(verb: String, suffix: String): String {
        //TODO add rules
        return verb.dropLast(2)
    }

    private fun getSuffixGroup(verb: String): SuffixGroup? =
        when{
            verb.endsWith(VerbEnds.AR) -> SuffixGroup("o", "as", "a", "amos", "ais", "am")
            verb.endsWith(VerbEnds.ER) -> SuffixGroup("o", "es", "a", "emos", "eis", "em")
            verb.endsWith(VerbEnds.IR) -> SuffixGroup("o", "es", "a", "imos", "is" , "em")
            else ->null
        }
    override fun toString(): String {
        return "IndicativePresentTenseConjugator"
    }
}