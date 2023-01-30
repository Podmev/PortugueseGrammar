package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.verb.*
import com.podmev.portuguese.engine.conjugator.analytic.DefectiveVerbs
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

@Suppress("ClassName")
object PersonalInfinitiveTenseConjugator : BasicTenseConjugator, FiniteTenseConjugator() {
    val commonSuffix = SuffixGroup("", "es", "", "mos", "des", "em", droppingSuffixLength = 0)
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()

    /*delete common, because doesn't fit this tense*/
    override val commonDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() =
            mapOf(
                Pair(
                    DefectiveGroup(false, false, true, false, false, false),
                    listOf(
                        DefectiveVerbs.APRAZER,
                        DefectiveVerbs.DOER,
                        DefectiveVerbs.GEAR,
                        DefectiveVerbs.NEVAR,
                        DefectiveVerbs.PRAZER,
                    )
                )
            )

    object I_Letter_To_I_Acute_Letter_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean =
            verbArgs.isSecondSingular() || verbArgs.isThirdPlural()

        override val wordEnding: String = VerbEnds.IR
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            VerbHelper.replaceIfNecessaryLastI_LetterForI_Acute_LetterOrNull(verb)
    }

    /*change last 'ô' for 'o': with circumflex. verbs pôr, oppôr*/
    object O_Circumflex_Letter_To_O_Letter_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean =
            !verbArgs.isFirstOrThirdSingular()

        override val wordEnding: String = VerbEnds.O_CIRCUMFLEX_R
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String =
            Wordifier.deleteLastDiacritics(verb)
    }

    override val baseChangingRules: List<BaseChangingRule> = listOf(
        I_Letter_To_I_Acute_Letter_Rule,
        O_Circumflex_Letter_To_O_Letter_Rule
    )

    override fun toString(): String {
        return "PersonalInfinitiveTenseConjugator"
    }
}