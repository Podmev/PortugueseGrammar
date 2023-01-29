package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs
import com.podmev.portuguese.engine.utils.verb.VerbEnds
/*malquerêssemos -br / malquiséssemos - pt

* */
object IndicativeImperfectTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("ava", "avas", "ava", "ávamos", "áveis", "avam")
    override val erSuffix = SuffixGroup("ia", "ias", "ia", "íamos", "íeis", "iam")
    override val irSuffix = erSuffix //exactly the same

    val specialSuffix = SuffixGroup("ía", "ías", "ía", "íamos", "íeis", "íam")


    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(
            IrregularVerbs.or.POR,
            IrregularForm(FormGroup("punha", "punhas", "punha", "púnhamos", "púnheis", "punham"))
        ),
        Pair(IrregularVerbs.er.SER, IrregularForm(FormGroup("era", "eras", "era", "éramos", "éreis", "eram"))),
        Pair(
            IrregularVerbs.er.TER,
            IrregularForm(FormGroup("tinha", "tinhas", "tinha", "tínhamos", "tínheis", "tinham"))
        ),
        Pair(
            IrregularVerbs.ir.VIR,
            IrregularForm(FormGroup("vinha", "vinhas", "vinha", "vínhamos", "vínheis", "vinham"))
        )
    )

    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) = specialSuffix
    }

    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UIR
        override val exceptions: List<String> = listOf("seguir", "extinguir", "distinguir", "retorquir")
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) = specialSuffix
    }

    object OER_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.OER
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) = specialSuffix

    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
        AIR_Suffix_Rule,
        UIR_Suffix_Rule,
        OER_Suffix_Rule
    )
    override val baseChangingRules: List<BaseChangingRule>
        get() = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()

    override fun toString(): String {
        return "IndicativeImperfectTenseConjugator"
    }
}