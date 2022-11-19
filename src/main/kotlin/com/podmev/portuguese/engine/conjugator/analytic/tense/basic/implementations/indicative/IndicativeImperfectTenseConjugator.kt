package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator

object IndicativeImperfectTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("ava", "avas", "ava", "ávamos", "áveis", "avam")
    override val erSuffix = SuffixGroup("ia", "ias", "ia", "íamos", "íeis", "iam")
    override val irSuffix = SuffixGroup("ia", "ias", "ia", "íamos", "íeis", "iam")

    override val irregularForms: Map<String, IrregularForm>
        get() = TODO("Not yet implemented")
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
        get() = TODO("Not yet implemented")
    override val baseChangingRules: List<BaseChangingRule>
        get() = TODO("Not yet implemented")
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = TODO("Not yet implemented")

    override fun toString(): String {
        return "IndicativeImperfectTenseConjugator"
    }
}