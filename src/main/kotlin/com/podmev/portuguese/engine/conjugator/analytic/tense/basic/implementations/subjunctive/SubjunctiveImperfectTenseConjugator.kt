package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.SpecialVerbBaseByTense
import com.podmev.portuguese.engine.conjugator.analytic.ThirdPluralIndicativePreteriteSpecialVerbBase

object SubjunctiveImperfectTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("asse", "asses", "asse", "ássemos", "ásseis", "assem")
    override val erSuffix = SuffixGroup("esse", "esses", "esse", "êssemos", "êsseis", "essem")
    override val irSuffix = SuffixGroup("isse", "isses", "isse", "íssemos", "ísseis", "issem")

    override val specialVerbBaseByTense: SpecialVerbBaseByTense = ThirdPluralIndicativePreteriteSpecialVerbBase

    override val irregularForms: Map<String, IrregularForm>
        get() = mapOf()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
        get() = listOf()
    override val baseChangingRules: List<BaseChangingRule>
        get() = listOf()


    override fun toString(): String {
        return "SubjunctiveImperfectTenseConjugator"
    }
}