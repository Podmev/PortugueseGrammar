package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs

object IndicativePreteriteTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("ei", "aste", "ou", "amos", "astes", "aram")
    override val erSuffix = SuffixGroup("i", "este", "eu", "emos", "estes", "eram")
    override val irSuffix = SuffixGroup("i", "iste", "iu", "imos", "istes", "iram")

    //special changes in Portugal for -ar suffix for nós
    override val arSuffixPortugal = arSuffix.copy(pluralFirst = "ámos")

    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(
            IrregularVerbs.or.POR,
            IrregularForm(FormGroup("pus", "puseste", "pôs", "pusemos", "pusestes", "puseram"))
        ),

        Pair(
            IrregularVerbs.ar.ESTAR,
            IrregularForm(FormGroup("estive", "estiveste", "esteve", "estivemos", "estivestes", "estiveram"))
        ),
        Pair(IrregularVerbs.ar.DAR, IrregularForm(FormGroup("dei", "deste", "deu", "demos", "destes", "deram"))),

        Pair(IrregularVerbs.er.SER, IrregularForm(FormGroup("fui", "foste", "foi", "fomos", "fostes", "foram"))),
        Pair(
            IrregularVerbs.er.TER,
            IrregularForm(FormGroup("tive", "tiveste", "teve", "tivemos", "tivestes", "tiveram"))
        ),
        Pair(
            IrregularVerbs.er.HAVER,
            IrregularForm(FormGroup("houve", "houveste", "houve", "houvemos", "houvestes", "houveram"))
        ),
        Pair(
            IrregularVerbs.er.FAZER,
            IrregularForm(FormGroup("fiz", "fizeste", "fez", "fizemos", "fizestes", "fizeram"))
        ),
        Pair(
            IrregularVerbs.er.DIZER,
            IrregularForm(FormGroup("disse", "disseste", "disse", "dissemos", "dissestes", "disseram"))
        ),
        Pair(
            IrregularVerbs.er.PODER,
            IrregularForm(FormGroup("pude", "pudeste", "pôde", "pudemos", "pudestes", "puderam"))
        ),
        Pair(IrregularVerbs.er.VER, IrregularForm(FormGroup("vi", "viste", "viu", "vimos", "vistes", "viram"))),
        Pair(
            IrregularVerbs.er.SABER,
            IrregularForm(FormGroup("soube", "soubeste", "soube", "soubemos", "soubestes", "souberam"))
        ),
        Pair(
            IrregularVerbs.er.QUERER,
            IrregularForm(FormGroup("quis", "quiseste", "quis", "quisemos", "quisestes", "quiseram"))
        ),
        Pair(IrregularVerbs.er.LER, IrregularForm(FormGroup("li", "leste", "leu", "lemos", "lestes", "leram"))),
        Pair(
            IrregularVerbs.er.TRAZER,
            IrregularForm(FormGroup("trouxe", "trouxeste", "trouxe", "trouxe", "trouxestes", "trouxeram"))
        ),
//        Pair(IrregularVerbs.er.PERDER, ), regular
        Pair(
            IrregularVerbs.er.CABER,
            IrregularForm(FormGroup("coube", "coubeste", "coube", "coubemos", "coubestes", "couberam"))
        ),
//        Pair(IrregularVerbs.er.PROVER, ), regular
//        Pair(IrregularVerbs.er.CRER, ), regular
//        Pair(IrregularVerbs.er.REQUERER, ), regular
//        Pair(IrregularVerbs.er.VALER, ), regular
//        Pair(IrregularVerbs.er.ERGUER, ), regular
//
        Pair(IrregularVerbs.ir.VIR, IrregularForm(FormGroup("vim", "vieste", "veio", "viemos", "viestes", "vieram"))),
//        Pair(IrregularVerbs.ir.OUVIR,), regular
//        Pair(IrregularVerbs.ir.PEDIR, ), regular
        Pair(IrregularVerbs.ir.IR, IrregularForm(FormGroup("fui", "foste", "foi", "fomos", "fostes", "foram"))),
//        Pair(IrregularVerbs.ir.DORMIR, ), regular
//        Pair(IrregularVerbs.ir.RIR, ), regular
    )

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule>
        get() = emptyList()
    override val baseChangingRules: List<BaseChangingRule>
        get() = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()

    override fun toString(): String {
        return "IndicativePreteriteTenseConjugator"
    }
}