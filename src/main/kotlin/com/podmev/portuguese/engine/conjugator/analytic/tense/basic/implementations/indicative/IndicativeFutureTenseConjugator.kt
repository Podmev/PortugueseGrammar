package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs

object IndicativeFutureTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    private val commonSuffix = SuffixGroup("ei", "ás", "á", "emos", "eis", "ão")
    override val arSuffix = commonSuffix.prependIndent("ar")
    override val erSuffix = commonSuffix.prependIndent("er")
    override val irSuffix = commonSuffix.prependIndent("ir")
    val orSuffix = commonSuffix.prependIndent("or")

    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(IrregularVerbs.or.POR, IrregularForm(orSuffix.toFormGroupWithIndent("p"))),
        Pair(IrregularVerbs.er.FAZER, IrregularForm(arSuffix.toFormGroupWithIndent("f"))),
        Pair(IrregularVerbs.er.DIZER, IrregularForm(irSuffix.toFormGroupWithIndent("d"))),
        Pair(IrregularVerbs.er.TRAZER, IrregularForm(arSuffix.toFormGroupWithIndent("tr")))
    )
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val baseChangingRules: List<BaseChangingRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "IndicativeFutureTenseConjugator"
    }
}