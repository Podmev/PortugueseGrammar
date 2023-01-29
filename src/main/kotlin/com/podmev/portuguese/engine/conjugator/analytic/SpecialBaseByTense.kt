package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.PLURAL
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.SINGULAR
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.FIRST
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.THIRD
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePreteriteTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments

abstract class SpecialVerbBaseByTense(
    val tense: GrammaticalTense,
    val verbArgs: VerbArguments,
    val amountOfTakingCharsFromTheEnd: Int
) {
    fun getForm(verb: String, settings: ConjugateSettings): List<String> =
        AnalyticConjugator.conjugateVerb(verb, tense, verbArgs, settings)

    fun getBasePlusInfinitiveEnding(verb: String, settings: ConjugateSettings): String? {
        val base = getBase(verb, changeSettings(settings)) ?: return null
        return base + verb.takeLast(amountOfTakingCharsFromTheEnd)
    }

    abstract fun getBase(verb: String, settings: ConjugateSettings): String?
    abstract fun changeSettings(settings: ConjugateSettings): ConjugateSettings
}

object FirstSingularIndicativePresentSpecialVerbBase :
    SpecialVerbBaseByTense(
        tense = IndicativePresentTense,
        verbArgs = VerbArguments(
            person = FIRST,
            number = SINGULAR,
            gender = GrammaticalGender.UNDEFINED,
            voice = GrammaticalVoice.ACTIVE
        ),
        amountOfTakingCharsFromTheEnd = 2
    ) {

    override fun getBase(verb: String, settings: ConjugateSettings): String? {
        val form = getForm(verb, settings).firstOrNull() ?: return null
        return form.dropLast(1) //dropping ending 'o'
    }

    override fun changeSettings(settings: ConjugateSettings): ConjugateSettings =
        settings.copy(ignoreDefective = true)

}

object ThirdPluralIndicativePreteriteSpecialVerbBase :
    SpecialVerbBaseByTense(
        tense = IndicativePreteriteTense,
        verbArgs = VerbArguments(
            person = THIRD,
            number = PLURAL,
            gender = GrammaticalGender.UNDEFINED,
            voice = GrammaticalVoice.ACTIVE
        ),
        amountOfTakingCharsFromTheEnd = 1
    ) {

    override fun getBase(verb: String, settings: ConjugateSettings): String? {
        val form = getForm(verb, settings).firstOrNull() ?: return null
        return form.dropLast(3)
    }

    override fun changeSettings(settings: ConjugateSettings): ConjugateSettings =
        settings.copy(ignoreDefective = true)

}

object ThirdPluralIndicativePreteriteSpecialVerbBase2 :
    SpecialVerbBaseByTense(
        tense = IndicativePreteriteTense,
        verbArgs = VerbArguments(
            person = THIRD,
            number = PLURAL,
            gender = GrammaticalGender.UNDEFINED,
            voice = GrammaticalVoice.ACTIVE
        ),
        amountOfTakingCharsFromTheEnd = 0
    ) {

    override fun getBase(verb: String, settings: ConjugateSettings): String? {
        val form = getForm(verb, settings).firstOrNull() ?: return null
        return form.dropLast(2)
    }

    override fun changeSettings(settings: ConjugateSettings): ConjugateSettings =
        settings.copy(ignoreDefective = true)

}