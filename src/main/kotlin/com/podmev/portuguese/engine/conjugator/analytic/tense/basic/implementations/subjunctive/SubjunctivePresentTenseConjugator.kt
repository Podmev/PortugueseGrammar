package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.FirstSingularIndicativePresentSpecialVerbBase
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper

object SubjunctivePresentTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("e", "es", "e", "emos", "eis", "em")
    override val erSuffix = SuffixGroup("a", "as", "a", "amos", "ais", "am")
    override val irSuffix = erSuffix //it is exactly the same

    override val irregularForms: Map<String, IrregularForm> = mapOf(
//        Pair(IrregularVerbs.or.POR, IrregularForm(suffixGroup = erSuffix)),

        Pair(IrregularVerbs.ar.ESTAR, IrregularForm(base = "estej", suffixGroup = erSuffix)),
        Pair(IrregularVerbs.ar.DAR, IrregularForm(FormGroup("dê", "dês", "dê", "demos", "deis", "deem"))),

        Pair(IrregularVerbs.er.SER, IrregularForm(base = "sej")),
//        Pair(IrregularVerbs.er.TER, IrregularForm(base="tenh")),
//        Pair(IrregularVerbs.er.HAVER, IrregularForm(base="haj")), //but it is defective too
//        Pair(IrregularVerbs.er.FAZER, IrregularForm(base="faç")),
//        Pair(IrregularVerbs.er.DIZER, IrregularForm(base="dig")),
//        Pair(IrregularVerbs.er.PODER, IrregularForm(base="poss")),
//        Pair(IrregularVerbs.er.VER, IrregularForm(base = "vej")),
//        Pair(IrregularVerbs.er.SABER, IrregularForm(base="saib")),
//        Pair(IrregularVerbs.er.QUERER, IrregularForm(base="queir")),
//
//        Pair(IrregularVerbs.er.LER, IrregularForm(base="lei")),
//        Pair(IrregularVerbs.er.TRAZER, IrregularForm(base="trag")),
//        Pair(IrregularVerbs.er.PERDER, IrregularForm(base = "perc")),
//        Pair(IrregularVerbs.er.CABER, IrregularForm(base = "caib")),
//        Pair(IrregularVerbs.er.PROVER, IrregularForm(base = "provej")),
//        Pair(IrregularVerbs.er.CRER, IrregularForm(base = "crei")),
//        Pair(IrregularVerbs.er.REQUERER, IrregularForm(base = "requeir")),
//        Pair(IrregularVerbs.er.VALER, IrregularForm(base = "valh")),
//        Pair(IrregularVerbs.er.ERGUER, IrregularForm(base = "erg")),
//
//        Pair(IrregularVerbs.ir.VIR, IrregularForm(base = "venh")),
//        Pair(IrregularVerbs.ir.OUVIR, IrregularForm(base = "ouço")),
//        Pair(IrregularVerbs.ir.PEDIR, IrregularForm(base = "peço")),
        Pair(IrregularVerbs.ir.IR, IrregularForm(FormGroup("vá", "vás", "vá", "vamos", "vades", "vão"))),
//        Pair(IrregularVerbs.ir.DORMIR, IrregularForm(base="durm")),
//        Pair(IrregularVerbs.ir.RIR, IrregularForm(base = "ri")),
    )

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()

    override val specialVerbBaseByTense = FirstSingularIndicativePresentSpecialVerbBase

    object C_TO_QU_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            VerbHelper.replaceIfNecessaryC_LetterForQU_FragmentOrNull(verb)
    }

    object G_TO_GU_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            VerbHelper.replaceIfNecessaryG_LetterForGU_FragmentOrNull(verb)
    }

    //already for changed verbs
    override val baseChangingRules = listOf(
        C_TO_QU_Rule,
        G_TO_GU_Rule,
    )

    override fun toString(): String {
        return "SubjunctivePresentTenseConjugator"
    }
}