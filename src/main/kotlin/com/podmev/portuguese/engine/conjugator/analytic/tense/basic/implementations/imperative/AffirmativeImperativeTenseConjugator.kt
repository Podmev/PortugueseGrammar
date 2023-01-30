package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isSecond
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative.IndicativePresentTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive.SubjunctivePresentTenseConjugator

/*

tu, vos - take presentIndicative, but take last letter (s)
ele, nos, eles - just take subjunctive
 */
object AffirmativeImperativeTenseConjugator : BasicTenseConjugator, FiniteTenseConjugator() {
    //doesn't matter what is suffix, because we use originConjugator
    val commonSuffix = emptySuffixGroup
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val globalDefectiveGroup = DefectiveGroup(false, true, true, true, true, true)

    //TODO refactor more organized
    override val originConjugator: Conjugator = object : Conjugator {
        override fun conjugateVerb(
            verbInInfinitive: String,
            tense: GrammaticalTense,
            verbArgs: VerbArguments,
            settings: ConjugateSettings
        ): List<String> =

            when {
                verbArgs.isSecond() -> {
                    val presentForms = IndicativePresentTenseConjugator.conjugateVerb(
                        verbInInfinitive,
                        IndicativePresentTense,
                        verbArgs,
                        settings
                    )
                    //dropping last s
                    presentForms.map { it.dropLast(1) }
                }

                else -> SubjunctivePresentTenseConjugator.conjugateVerb(
                    verbInInfinitive,
                    SubjunctivePresentTense,
                    verbArgs,
                    settings
                )
            }
    }

    override val baseChangingRules: List<BaseChangingRule> = emptyList()
    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "AffirmativeImperativeTenseConjugator"
    }
}