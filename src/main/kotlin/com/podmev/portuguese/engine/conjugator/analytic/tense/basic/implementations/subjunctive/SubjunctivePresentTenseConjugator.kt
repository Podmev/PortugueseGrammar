@file:Suppress("ClassName")

package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isFirstOrSecondPlural
import com.podmev.portuguese.engine.conjugator.analytic.*
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

/*
desdar, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL: desdemos, desdêmos
malquerer - brasil malquera, pt - malqueira
parir - paira/para both forms or defective completely
* */
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
        Pair(IrregularVerbs.er.HAVER, IrregularForm(base = "haj")), //but it is defective too
//        Pair(IrregularVerbs.er.FAZER, IrregularForm(base="faç")),
//        Pair(IrregularVerbs.er.DIZER, IrregularForm(base="dig")),
//        Pair(IrregularVerbs.er.PODER, IrregularForm(base="poss")),
//        Pair(IrregularVerbs.er.VER, IrregularForm(base = "vej")),
        Pair(IrregularVerbs.er.SABER, IrregularForm(base = "saib")),
        Pair(IrregularVerbs.er.QUERER, IrregularForm(base = "queir")),
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
        Pair(IrregularVerbs.ir.PARIR, IrregularForm(base = "pair")),

//        Pair(IrregularVerbs.ir.DORMIR, IrregularForm(base="durm")),
//        Pair(IrregularVerbs.ir.RIR, IrregularForm(base = "ri")),
    )

    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf(
            Pair(
                DefectiveGroup(false, false, false, false, false, false),
                listOf(
                    DefectiveVerbs.ABOLIR,
                    DefectiveVerbs.BARRIR,
                    DefectiveVerbs.COLORIR,
                    DefectiveVerbs.DELIR,
                    DefectiveVerbs.DEMOLIR,
                    DefectiveVerbs.DESCOLORIR,
                    DefectiveVerbs.EMPEDERNIR,
                    DefectiveVerbs.EXPLODIR,
                    DefectiveVerbs.FALIR,
                    DefectiveVerbs.FLORIR,
                    DefectiveVerbs.GANIR,
                    DefectiveVerbs.LATIR,
                    DefectiveVerbs.REMIR,
                    DefectiveVerbs.RUIR
                )
            )
        )

    override val specialVerbBaseByTense = FirstSingularIndicativePresentSpecialVerbBase

//    object UZIR_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.UZIR
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            regularSuffix.copy(singularThird = "") //finishes with -z
//    }
//
//    object AZER_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.AZER
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            regularSuffix.copy(singularThird = "") //finishes with -z
//    }
//
//    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.AIR
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            SuffixGroup("io", "is", "i", "ímos", "ís", regularSuffix.pluralThird)
//    }
//
//    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.UIR
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            SuffixGroup(regularSuffix.singularFirst, "is", "i", "ímos", "ís", regularSuffix.pluralThird)
//    }

    object EAR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.EAR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(
                "ie", "ies", "ie", regularSuffix.pluralFirst, regularSuffix.pluralSecond, "iem",
                droppingSuffixLength = 3 //need to take 3, because of base we take from inticative present
            )
    }

    //we need to take four letters
    //works only for fixed list of verbs MARIO - first letters of verbs
    object IAR_Suffix_MARIO_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.IAR
        override val fixedVerbList = listOf("mediar", "ansiar", "remediar", "incendiar", "odiar",
            "intermediar" // additional
        )
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(
                "eie", "eies", "eie", "iemos", "ieis", "eiem",
                droppingSuffixLength = 4
            )
    }
//
//    //we need to take three letters
//    object OER_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.OER
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            regularSuffix.extendChar('o').copy(singularSecond = "óis", singularThird = "ói")
//    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
//        UZIR_Suffix_Rule,
//        AZER_Suffix_Rule,
//        AIR_Suffix_Rule,
//        UIR_Suffix_Rule,
        EAR_Suffix_Rule,
        IAR_Suffix_MARIO_Rule,
//        OER_Suffix_Rule
    )

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

    object C_Cedilla_TO_C_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            VerbHelper.replaceIfNecessaryC_Cedilla_LetterForC_LetterOrNull(verb)
    }

    object Remove_Diacritics_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstOrSecondPlural()
        override val fixedVerbList: List<String>
            get() = listOf("aguar","enxaugar", "europeizar", "mobiliar", "resfolegar", "saudar")
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String =
            Wordifier.deleteAllDiacriticMarks(verb)
    }

    //already for changed verbs
    override val baseChangingRules = listOf(
        C_TO_QU_Rule,
        G_TO_GU_Rule,
        C_Cedilla_TO_C_Rule,
        Remove_Diacritics_Rule
    )

    override fun toString(): String {
        return "SubjunctivePresentTenseConjugator"
    }
}