package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.SINGULAR
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.FIRST
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePresentTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

abstract class SpecialVerbBaseByTense(
    val tense: GrammaticalTense,
    val verbArgs: VerbArguments
) {
    fun getForm(verb: String, settings: ConjugateSettings): List<String> =
        AnalyticConjugator.conjugateVerb(verb, tense, verbArgs, settings)

    fun getBasePlusInfinitiveEnding(verb: String, settings: ConjugateSettings): String? {
        val base = getBase(verb, settings) ?: return null
        return base + verb.takeLast(2)
    }

    abstract fun getBase(verb: String, settings: ConjugateSettings): String?
    abstract fun changeSettings(settings: ConjugateSettings): ConjugateSettings
}

object FirstSingularIndicativePresentSpecialVerbBase :
    SpecialVerbBaseByTense(
        IndicativePresentTense,
        VerbArguments(
            person = FIRST,
            number = SINGULAR,
            gender = GrammaticalGender.UNDEFINED,
            voice = GrammaticalVoice.ACTIVE
        )
    ) {

    override fun getBase(verb: String, settings: ConjugateSettings): String? {
        val form = getForm(verb, settings).firstOrNull() ?: return null
        return form.dropLast(1) //dropping ending 'o'
    }

    override fun changeSettings(settings: ConjugateSettings): ConjugateSettings =
        settings.copy(ignoreDefective = true)

}