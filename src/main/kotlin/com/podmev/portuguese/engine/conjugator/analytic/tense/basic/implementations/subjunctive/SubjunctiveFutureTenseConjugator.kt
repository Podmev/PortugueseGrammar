package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.SpecialVerbBaseByTense
import com.podmev.portuguese.engine.conjugator.analytic.ThirdPluralIndicativePreteriteSpecialVerbBase
import com.podmev.portuguese.engine.conjugator.analytic.ThirdPluralIndicativePreteriteSpecialVerbBase2

object SubjunctiveFutureTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    val commonSuffix = SuffixGroup("", "es", "", "mos", "des", "em", droppingSuffixLength = 0)
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val specialVerbBaseByTense: SpecialVerbBaseByTense = ThirdPluralIndicativePreteriteSpecialVerbBase2

    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val baseChangingRules: List<BaseChangingRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "SubjunctiveFutureTenseConjugator"
    }
}