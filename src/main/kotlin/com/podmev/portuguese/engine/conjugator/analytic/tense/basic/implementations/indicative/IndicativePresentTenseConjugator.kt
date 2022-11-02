package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isFirstSingular
import com.podmev.portuguese.engine.conjugator.analytic.BaseChangingRule
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.SpecialEndingSuffixRule
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryE_LetterForI_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryG_LetterForJ_LetterOrNull
import com.podmev.portuguese.engine.utils.verb.VerbEnds

object IndicativePresentTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator {
    override val arSuffix = SuffixGroup("o", "as", "a", "amos", "ais", "am")
    override val erSuffix = SuffixGroup("o", "es", "e", "emos", "eis", "em")
    override val irSuffix = SuffixGroup("o", "es", "e", "imos", "is", "em")

    object UZIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UZIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.copy(singularThird = "") //finishes with -z
    }
    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup("io", "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }
    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(regularSuffix.singularFirst, "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
        UZIR_Suffix_Rule,
        AIR_Suffix_Rule,
        UIR_Suffix_Rule
    )

    object C_TO_C_Cedilla_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull(verb)
    }

    object G_TO_J_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryG_LetterForJ_LetterOrNull(verb)
    }

    object EGU_TO_IG_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull(verb)
    }

    object E_TO_I_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryE_LetterForI_LetterOrNull(verb)
    }

    override val baseChangingRules = listOf(
        C_TO_C_Cedilla_Rule,
        G_TO_J_Rule,
        EGU_TO_IG_Rule,
//        E_TO_I_Rule - excluded for now
    )

    override fun toString(): String {
        return "IndicativePresentTenseConjugator"
    }
}