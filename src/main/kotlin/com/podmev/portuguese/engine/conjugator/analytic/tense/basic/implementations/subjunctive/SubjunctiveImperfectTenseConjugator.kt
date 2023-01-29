package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.Alphabet
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.A_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isFirstOrSecondPlural
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.SpecialVerbBaseByTense
import com.podmev.portuguese.engine.conjugator.analytic.ThirdPluralIndicativePreteriteSpecialVerbBase
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.utils.lang.getFromEnd

/*malquerêssemos -br / malquiséssemos - pt

* */
object SubjunctiveImperfectTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    val commonSuffix = SuffixGroup("sse", "sses", "sse", "ssemos", "sseis", "ssem", droppingSuffixLength = 1)
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val specialVerbBaseByTense: SpecialVerbBaseByTense = ThirdPluralIndicativePreteriteSpecialVerbBase

    object DiacriticsBeforeEnding_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstOrSecondPlural()
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String {
            val lastVowelChar = verb.getFromEnd(1)
            val exactLetter = Alphabet.parseExactLetter(lastVowelChar)!!
            val baseLetter = exactLetter.genericLetter.baseLetter()
            val diacriticMark = when (baseLetter) {
                E_Letter -> (if (verbIsChanged) AcuteDiacriticMark else CircumflexDiacriticMark)
                I_Letter, A_Letter -> AcuteDiacriticMark
                O_Letter -> CircumflexDiacriticMark
                else -> throw Exception("impossible other letter from e, a, i, o, but had $baseLetter")

            }
            return Wordifier.addDiacriticsToLastLetterByPredicate(
                word = verb,
                diacriticMark = diacriticMark,
                predicate = Alphabet::isVowelChar
            )
        }

    }

    override val baseChangingRules: List<BaseChangingRule> = listOf(DiacriticsBeforeEnding_Rule)

    //all empty others
    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>> get() = mapOf()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()


    override fun toString(): String {
        return "SubjunctiveImperfectTenseConjugator"
    }
}