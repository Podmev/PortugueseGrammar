package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator

object IndicativeFutureTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    private val commonSuffix = SuffixGroup("ei", "ás", "á", "emos", "eis", "ão")
    override val arSuffix = commonSuffix.prependIndent("ar")
    override val erSuffix = commonSuffix.prependIndent("er")
    override val irSuffix = commonSuffix.prependIndent("ir")

    override val irregularForms: Map<String, IrregularForm>
        get() = TODO("Not yet implemented")
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
        get() = TODO("Not yet implemented")
    override val baseChangingRules: List<BaseChangingRule>
        get() = TODO("Not yet implemented")
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = TODO("Not yet implemented")

    override fun toString(): String {
        return "IndicativeFutureTenseConjugator"
    }
}