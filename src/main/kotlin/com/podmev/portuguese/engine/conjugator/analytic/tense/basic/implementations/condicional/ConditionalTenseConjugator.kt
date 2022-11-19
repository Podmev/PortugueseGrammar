package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.condicional

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator

object ConditionalTenseConjugator : BasicTenseConjugator  , FiniteTenseConjugator() {
    private val commonSuffix = SuffixGroup("ia", "ias", "ia", "íamos", "íeis", "iam")
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
        return "ConditionalTenseConjugator"
    }
}