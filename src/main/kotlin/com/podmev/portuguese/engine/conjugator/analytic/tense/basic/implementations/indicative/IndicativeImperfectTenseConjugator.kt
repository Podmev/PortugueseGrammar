package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs

object IndicativeImperfectTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("ava", "avas", "ava", "ávamos", "áveis", "avam")
    override val erSuffix = SuffixGroup("ia", "ias", "ia", "íamos", "íeis", "iam")
    override val irSuffix = erSuffix //exactly the same

    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(IrregularVerbs.or.POR, IrregularForm(FormGroup("punha", "punhas", "punha", "púnhamos", "púnheis", "punham"))),
        Pair(IrregularVerbs.er.SER, IrregularForm(FormGroup("era", "eras", "era", "éramos", "éreis", "eram"))),
        Pair(IrregularVerbs.er.TER, IrregularForm(FormGroup("tinha", "tinhas", "tinha", "tínhamos", "tínheis", "tinham"))),
        Pair(IrregularVerbs.ir.VIR, IrregularForm(FormGroup("vinha", "vinhas", "vinha", "vínhamos", "vínheis", "vinham"))),
    )
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
        get() = emptyList()
    override val baseChangingRules: List<BaseChangingRule>
        get() = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()

    override fun toString(): String {
        return "IndicativeImperfectTenseConjugator"
    }
}