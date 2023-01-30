package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive.SubjunctivePresentTenseConjugator

object NegativeImperativeTenseConjugator : BasicTenseConjugator, FiniteTenseConjugator() {
    //doesn't matter what is suffix, because we use originConjugator
    val commonSuffix = emptySuffixGroup
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val globalDefectiveGroup = DefectiveGroup(false, true, true, true, true, true)

    override val originConjugator: Conjugator = SubjunctivePresentTenseConjugator

    override val baseChangingRules: List<BaseChangingRule> = emptyList()
    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "NegativeImperativeTenseConjugator"
    }
}