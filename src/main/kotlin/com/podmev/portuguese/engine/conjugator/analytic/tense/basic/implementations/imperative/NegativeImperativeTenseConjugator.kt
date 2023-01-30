package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.DefectiveVerbs
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive.SubjunctivePresentTenseConjugator
/*just need to fix 213 forms in db
* */
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