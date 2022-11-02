package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isFirstSingular
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryEGU_FragmentForEG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryE_LetterForI_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryG_LetterForJ_LetterOrNull
import com.podmev.portuguese.engine.utils.verb.VerbEnds

object IndicativePresentTenseConjugator : IndicativeMoodTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        //TODO add exceptions
        val regularForm = regularChanging(verbInInfinitive, verbArgs)
        if (regularForm != null) {
            return listOf(regularForm)
        }
        return listOf()
    }

    private fun regularChanging(verb: String, verbArgs: VerbArguments): String? {
        val suffix = getSuffixGroup(verb)?.getSuffix(verbArgs) ?: return null //in case of -or
        val preparedBase = prepareBase(verb, suffix, verbArgs)
        return preparedBase + suffix
    }

    private fun prepareBase(verb: String, suffix: String, verbArgs: VerbArguments): String =
        VerbHelper.dropInfinitiveSuffixXR(prepareInfinitive(verb, suffix, verbArgs))

    private fun prepareInfinitive(infinitive: String, suffix: String, verbArgs: VerbArguments): String {
        if (verbArgs.isFirstSingular()) {
            //TODO make stream with first
            //c->c_cedilla for -er
            val preparedCedilla = replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull(infinitive)
            if (preparedCedilla != null) return preparedCedilla
            //g->j
            val preparedG = replaceIfNecessaryG_LetterForJ_LetterOrNull(infinitive)
            if (preparedG != null) return preparedG
            //egu->ig
            val preparedEGU = replaceIfNecessaryEGU_FragmentForEG_FragmentOrNull(infinitive)
            if (preparedEGU != null) return preparedEGU
            //e-i
            //makes more wrong 2202 to 2234
//            val preparedEI = replaceIfNecessaryE_LetterForI_LetterOrNull(infinitive)
//            if (preparedEI != null) return preparedEI
        }
        //TODO add rules
        return infinitive
    }

    private fun getSuffixGroup(verb: String): SuffixGroup? {
        val regularSuffix = getRegularSuffixGroup(verb) ?: return null
        return when {
            verb.endsWith(VerbEnds.UZIR) -> regularSuffix.copy(singularThird = "") //finishes with -z
            else -> regularSuffix
        }
    }


    private fun getRegularSuffixGroup(verb: String): SuffixGroup? =
        when {
            verb.endsWith(VerbEnds.AR) -> SuffixGroup("o", "as", "a", "amos", "ais", "am")
            verb.endsWith(VerbEnds.ER) -> SuffixGroup("o", "es", "e", "emos", "eis", "em")
            verb.endsWith(VerbEnds.IR) -> SuffixGroup("o", "es", "e", "imos", "is", "em")
            else -> null
        }

    override fun toString(): String {
        return "IndicativePresentTenseConjugator"
    }
}