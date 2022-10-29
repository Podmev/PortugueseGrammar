package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.utils.word.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

object GerundTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        val preparedInfinitive = prepareInfinitive(verbInInfinitive)
        val preparedBase = takeInfinitiveSuffix(preparedInfinitive)
        val result = regularChanging(preparedBase)
        return listOf(result)
    }

    const val regularSuffix = "ndo"

    private fun regularChanging(preparedBase: String):String = preparedBase + regularSuffix
    /*drop the last letter 'r'*/
    private fun takeInfinitiveSuffix(infinitive: String):String = infinitive.dropLast(1)

    private fun prepareInfinitive(originalInfinitive: String): String {
        if(originalInfinitive.endsWith(VerbEnds.O_CIRCUMFLEX_R)){
            return Wordifier.deleteLastDiacritics(originalInfinitive)
        }
        //the most of the cases we don't change anything
        return originalInfinitive
    }

    override fun toString(): String {
        return "GerundTenseConjugator"
    }
}