package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.Alphabet
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isSecondSingular
import com.podmev.portuguese.data.grammar.term.verb.isThirdPlural
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.SpecialVerbBaseByTense
import com.podmev.portuguese.engine.conjugator.analytic.ThirdPluralIndicativePreteriteSpecialVerbBase2
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.utils.lang.getFromEnd


object SubjunctiveFutureTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    val commonSuffix = SuffixGroup("", "es", "", "mos", "des", "em", droppingSuffixLength = 0)
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val specialVerbBaseByTense: SpecialVerbBaseByTense = ThirdPluralIndicativePreteriteSpecialVerbBase2

    object DiacriticsBeforeEnding_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override val wordPossibleEndings = listOf(VerbEnds.UIR, VerbEnds.AIR)
        override val exceptions: List<String> =
            listOf("seguir", "extinguir", "distinguir", "retorquir")

        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String {
            val lastVowelChar = verb.getFromEnd(1)
            val exactLetter = Alphabet.parseExactLetter(lastVowelChar)!!
            val genericLetter = exactLetter.genericLetter
            val updatedLetter =
                when {
                    verbArgs.isSecondSingular() || verbArgs.isThirdPlural() -> I_Acute_Letter
                    else -> I_Letter
                }
            return Wordifier.replaceLastFoundGenericLetter(verb, genericLetter, updatedLetter)
        }
    }

    override val baseChangingRules: List<BaseChangingRule> = listOf(
        DiacriticsBeforeEnding_Rule
    )
    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "SubjunctiveFutureTenseConjugator"
    }
}