package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator

object SubjunctivePresentTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("e", "es", "e", "emos", "eis", "em")
    override val erSuffix = SuffixGroup("a", "as", "a", "amos", "ais", "am")
    override val irSuffix = erSuffix //it is exactly the same

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf()
    override val baseChangingRules: List<BaseChangingRule> = listOf()
    override val irregularForms: Map<String, IrregularForm> = mapOf()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()


    override fun toString(): String {
        return "SubjunctivePresentTenseConjugator"
    }
}