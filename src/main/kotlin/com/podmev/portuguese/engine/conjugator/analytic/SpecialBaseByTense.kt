package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.SINGULAR
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.FIRST
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.THIRD
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePresentTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

abstract class SpecialVerbBaseByTense(
    val tense: GrammaticalTense,
    val verbArgs: VerbArguments,
    val backupVerbArgs: VerbArguments
) {
    fun getForm(verb: String): List<String> = AnalyticConjugator.conjugateVerb(verb, tense, verbArgs)
    fun getBackupForm(verb: String): List<String> = AnalyticConjugator.conjugateVerb(verb, tense, backupVerbArgs)

    fun getBasePlusInfinitiveEnding(verb: String): String? {
        val base = getBase(verb)?: return null
        return base + verb.takeLast(2)
    }

    abstract fun getBase(verb: String): String?
}

object FirstSingularIndicativePresentSpecialVerbBase :
    SpecialVerbBaseByTense(
        IndicativePresentTense,
        VerbArguments(
            person = FIRST,
            number = SINGULAR,
            gender = GrammaticalGender.UNDEFINED,
            voice = GrammaticalVoice.ACTIVE
        ),
        VerbArguments(
            person = THIRD,
            number = SINGULAR,
            gender = GrammaticalGender.UNDEFINED,
            voice = GrammaticalVoice.ACTIVE
        )
    ) {

    override fun getBase(verb: String) : String?{
        val form = getForm(verb).firstOrNull() ?: getBackupForm(verb).firstOrNull()?:return null
        return form.dropLast(1) //dropping ending 'o'
    }

}