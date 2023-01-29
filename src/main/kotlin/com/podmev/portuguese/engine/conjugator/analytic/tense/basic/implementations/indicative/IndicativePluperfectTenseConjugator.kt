package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.Alphabet
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CircumflexDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.A_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isFirstOrSecondPlural
import com.podmev.portuguese.data.grammar.term.verb.isSecondSingular
import com.podmev.portuguese.data.grammar.term.verb.isThirdPlural
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.SpecialVerbBaseByTense
import com.podmev.portuguese.engine.conjugator.analytic.ThirdPluralIndicativePreteriteSpecialVerbBase2
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.utils.lang.getFromEnd
/*
malquisera - pt, malquerera - br
* */
object IndicativePluperfectTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    val commonSuffix = SuffixGroup("a", "as", "a", "amos", "eis", "am", droppingSuffixLength = 0)
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val specialVerbBaseByTense: SpecialVerbBaseByTense = ThirdPluralIndicativePreteriteSpecialVerbBase2

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
    override val baseChangingRules: List<BaseChangingRule> = listOf(
        DiacriticsBeforeEnding_Rule
    )
    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "IndicativePluperfectTenseConjugator"
    }
}
