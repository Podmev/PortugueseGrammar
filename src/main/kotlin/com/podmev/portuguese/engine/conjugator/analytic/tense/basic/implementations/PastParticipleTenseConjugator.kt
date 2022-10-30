package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.UNDEFINED
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.utils.word.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

object PastParticipleTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        val preparedInfinitive = prepareInfinitive(verbInInfinitive)
        val preparedBase = VerbHelper.dropInfinitiveSuffixR(preparedInfinitive)
        val regularSuffix = getRegularSuffix(verbArgs.gender, verbArgs.number)
        val result = regularChanging(preparedBase, regularSuffix)
        return listOf(result)
    }

    private fun getRegularSuffix(gender: GrammaticalGender, number: GrammaticalNumber): String =
        when (number){
            SINGULAR, UNDEFINED  -> when(gender){
                MASCULINE, GrammaticalGender.UNDEFINED -> "do"
                FEMININE -> "da"
            }
            PLURAL -> when(gender){
                MASCULINE, GrammaticalGender.UNDEFINED -> "dos"
                FEMININE -> "das"
            }
        }

    private fun regularChanging(preparedBase: String, suffix: String):String = preparedBase + suffix

    private fun prepareInfinitive(infinitive: String): String {
        if(infinitive.endsWith(VerbEnds.O_CIRCUMFLEX_R)){
            return Wordifier.deleteLastDiacritics(infinitive)
        }
        if(infinitive.endsWith(VerbEnds.ER)){
            return Wordifier.replaceLastFoundGenericLetter(infinitive, E_Letter, I_Letter)
        }
        if(infinitive.endsWith(VerbEnds.IR)){
            val changedForm = VerbHelper.replaceIfNecessaryLastI_LetterForI_Acute_LetterOrNull(infinitive)
            if(changedForm!=null){
                return changedForm
            }
        }
        //the most of the cases we don't change anything
        return infinitive
    }

    override fun toString(): String {
        return "PastParticipleTenseConjugator"
    }
}