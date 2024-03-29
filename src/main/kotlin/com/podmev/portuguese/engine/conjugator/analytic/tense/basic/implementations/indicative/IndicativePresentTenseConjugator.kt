package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.O_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.U_Letter
import com.podmev.portuguese.data.grammar.term.verb.*
import com.podmev.portuguese.engine.conjugator.analytic.DefectiveVerbs
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryE_LetterForI_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryGU_FragmentForG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryG_LetterForJ_LetterOrNull
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

/*
* empedernir: firstSingular is missing in brazil, portugal - empedirno
* submergir/emergir: firstSingular is submerjo/emerjo in brazil, portugal - submerjo/emerjo or submirjo/emirjo
* malquerer: malquere - brasil, malquer - pt
*
*
Portugal
 «Eu ouço música para adormecer» ou «Eu oiço música para adormecer»?
As duas formas são corretas.
A variação entre o ditongo oi e ou é frequente na língua portuguesa,

loiro ou louro,
ouro ou oiro,
touro ou toiro,
dourado ou doirado,
loiça ou louça,
mouro ou moiro.


* * * * */
@Suppress("BooleanLiteralArgument", "ClassName")
object IndicativePresentTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("o", "as", "a", "amos", "ais", "am")
    override val erSuffix = SuffixGroup("o", "es", "e", "emos", "eis", "em")
    override val irSuffix = SuffixGroup("o", "es", "e", "imos", "is", "em")

    override val autoAddAcuteToE_LetterInDerivativesWith1Vowel = true

    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(IrregularVerbs.or.POR, IrregularForm(FormGroup("ponho", "pões", "põe", "pomos", "pondes", "põem"))),

        Pair(IrregularVerbs.ar.ESTAR, IrregularForm(FormGroup("estou", "estás", "está", null, null, "estão"))),
        Pair(IrregularVerbs.ar.DAR, IrregularForm(FormGroup("dou", "dás", "dá", null, null, "dão"))),

        Pair(IrregularVerbs.er.SER, IrregularForm(FormGroup("sou", "és", "é", "somos", "sois", "são"))),
        Pair(IrregularVerbs.er.TER, IrregularForm(FormGroup("tenho", "tens", "tem", "temos", "tendes", "têm"))),
        Pair(IrregularVerbs.er.HAVER, IrregularForm(FormGroup("hei", "hás", "há", null, null, "hão"))),
        Pair(IrregularVerbs.er.FAZER, IrregularForm(FormGroup("faço", null, "faz", null, null, null))),
        Pair(IrregularVerbs.er.DIZER, IrregularForm(FormGroup("digo", null, "diz", null, null, null))),
        Pair(IrregularVerbs.er.PODER, IrregularForm(FormGroup("posso", null, null, null, null, null))),
        Pair(IrregularVerbs.er.VER, IrregularForm(FormGroup("vejo", "vês", "vê", null, "vedes", "veem"))),
        Pair(IrregularVerbs.er.SABER, IrregularForm(FormGroup("sei", null, null, null, null, null))),
        Pair(IrregularVerbs.er.QUERER, IrregularForm(FormGroup(null, null, "quer", null, null, null))),
        //TODO change to suffix
        Pair(IrregularVerbs.er.LER, IrregularForm(FormGroup("leio", "lês", "lê", null, "ledes", "leem"))),
        Pair(IrregularVerbs.er.TRAZER, IrregularForm(FormGroup("trago", null, "traz", null, null, null))),
        Pair(IrregularVerbs.er.PERDER, IrregularForm(FormGroup("perco", null, null, null, null, null))),
        Pair(IrregularVerbs.er.CABER, IrregularForm(FormGroup("caibo", null, null, null, null, null))),
        Pair(IrregularVerbs.er.PROVER, IrregularForm(null, SuffixGroup("ejo", "ês", "ê", null, "edes", "eem"))),
        Pair(IrregularVerbs.er.CRER, IrregularForm(null, SuffixGroup("eio", "ês", "ê", null, "edes", "eem"))),
        Pair(IrregularVerbs.er.REQUERER, IrregularForm(FormGroup("requeiro", null, "requer", null, null, null))),
        Pair(IrregularVerbs.er.VALER, IrregularForm(FormGroup("valho", null, null, null, null, null))),
        Pair(IrregularVerbs.er.ERGUER, IrregularForm(FormGroup("ergo", null, null, null, null, null))),

        Pair(IrregularVerbs.ir.VIR, IrregularForm(FormGroup("venho", "vens", "vem", null, "vindes", "vêm"))),
        Pair(
            IrregularVerbs.ir.OUVIR,
            IrregularForm(listFormGroup = ListFormGroup(L("ouço", "oiço"), null, null, null, null, null))
        ),
        Pair(IrregularVerbs.ir.PEDIR, IrregularForm(FormGroup("peço", null, null, null, null, null))),
        Pair(IrregularVerbs.ir.IR, IrregularForm(FormGroup("vou", "vais", "vai", "vamos", "ides", "vão"))),
        Pair(IrregularVerbs.ir.DORMIR, IrregularForm(FormGroup("durmo", null, null, null, null, null))),
        //Think how to make
        Pair(IrregularVerbs.ir.SUBIR, IrregularForm(FormGroup(null, "sobes", "sobe", null, null, "sobem"))),
        //Think how to make
        Pair(IrregularVerbs.ir.FUGIR, IrregularForm(FormGroup(null, "foges", "foge", null, null, "fogem"))),
        Pair(IrregularVerbs.ir.RIR, IrregularForm(FormGroup("rio", "ris", "ri", null, "rides", "riem"))),
        Pair(IrregularVerbs.ir.PARIR, IrregularForm(FormGroup("pairo", null, null, null, null, null))),
        Pair(IrregularVerbs.ir.COBRIR, IrregularForm(FormGroup("cubro", null, null, null, null, null))),
        Pair(IrregularVerbs.ir.ENGOLIR, IrregularForm(FormGroup("engulo", null, null, null, null, null))),
        Pair(IrregularVerbs.ir.POLIR, IrregularForm(FormGroup("pulo", "pules", "pule", null, null, "pulem"))),
    )
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() =
            mapOf(
                Pair(
                    DefectiveGroup(false, false, false, true, true, false),
                    listOf(
                        DefectiveVerbs.ABOLIR,
                        DefectiveVerbs.COLORIR,
                        DefectiveVerbs.DEMOLIR,
                        DefectiveVerbs.DESCOLORIR,
                        DefectiveVerbs.FALIR,
                        DefectiveVerbs.FLORIR,
                        DefectiveVerbs.PARIR,
                        DefectiveVerbs.REMIR,
                        DefectiveVerbs.EMPEDERNIR,
                    )
                ),
                Pair(
                    DefectiveGroup(false, true, true, true, true, true),
                    listOf(

                        DefectiveVerbs.BARRIR,
                        DefectiveVerbs.DELIR,
                        DefectiveVerbs.EXPLODIR,
                        DefectiveVerbs.GANIR,
                        DefectiveVerbs.LATIR,
                        DefectiveVerbs.RUIR,
                    )
                )
            )

    object UZIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UZIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.copy(singularThird = "") //finishes with -z
    }

    object AZER_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AZER
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.copy(singularThird = "") //finishes with -z
    }

    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup("io", "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }

    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UIR
        override val exceptions: List<String> = listOf("seguir", "extinguir", "distinguir", "retorquir")
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(regularSuffix.singularFirst, "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }

    object EAR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.EAR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup("io", "ias", "ia", regularSuffix.pluralFirst, regularSuffix.pluralSecond, "iam")
    }

    //we need to take three letters
    //works only for fixed list of verbs MARIO - first letters of verbs
    object IAR_Suffix_MARIO_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.IAR
        override val fixedVerbList = listOf(
            "mediar", "ansiar", "remediar", "incendiar", "odiar",
            "intermediar" // additional
        )

        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(
                "eio", "eias", "eia", "iamos", "iais", "eiam",
                droppingSuffixLength = 3
            )
    }

    //we need to take three letters
    object OER_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.OER
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.extendChar('o').copy(singularSecond = "óis", singularThird = "ói")
    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
        UZIR_Suffix_Rule,
        AZER_Suffix_Rule,
        AIR_Suffix_Rule,
        UIR_Suffix_Rule,
        EAR_Suffix_Rule,
        IAR_Suffix_MARIO_Rule,
        OER_Suffix_Rule
    )

    object C_TO_C_Cedilla_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull(verb)
    }

    object G_TO_J_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            replaceIfNecessaryG_LetterForJ_LetterOrNull(verb)
    }

    object EGU_TO_IG_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull(verb)
    }

    object GU_TO_G_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()

        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            replaceIfNecessaryGU_FragmentForG_FragmentOrNull(verb)
    }

    object E_TO_I_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override val exceptions: List<String>
            get() = listOf("manutenir", "premir", "renhir", "convelir", "discernir", "emergir")

        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            replaceIfNecessaryE_LetterForI_LetterOrNull(verb)
    }

    object E_TO_I_Full_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = !verbArgs.isFirstOrSecondPlural()
        override val fixedVerbList: List<String>
            get() = listOf("agredir")

        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            replaceIfNecessaryE_LetterForI_LetterOrNull(verb)
    }

    object Construir_Destruir_U_TO_O_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isSecondSingular() || verbArgs.isThird()
        override val fixedVerbList: List<String> = listOf("construir", "destruir")
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            Wordifier.replaceLastFoundGenericLetter(
                word = verb,
                fromGenericLetter = U_Letter,
                toGenericLetter =
                if (verbArgs.isThirdPlural())
                    O_Letter
                else O_Acute_Letter //second-singular and third-singular
            )
    }

    object OIBIR_I_TO_I_Acute_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = !verbArgs.isFirstOrSecondPlural()
        override val wordEnding: String = "oibir"
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            Wordifier.replaceLastFoundGenericLetterInPrefix(
                word = verb,
                prefix = VerbHelper.dropInfinitiveSuffixXR(verb),
                fromGenericLetter = I_Letter,
                toGenericLetter = I_Acute_Letter
            )
    }


    object Second_Vowel_From_End_Acute_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = !verbArgs.isFirstOrSecondPlural()
        override val fixedVerbList = listOf("aguar", "europeizar", "mobiliar", "reunir", "saudar")
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            Wordifier.putDiacriticMarkOnLastVowelInPrefix(
                word = verb,
                prefix = VerbHelper.dropInfinitiveSuffixAllVowelsAndR(verb),
                diacriticMark = AcuteDiacriticMark
            )
    }

    object Third_Vowel_From_End_Acute_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = !verbArgs.isFirstOrSecondPlural()
        override val fixedVerbList = listOf("resfolegar")
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            Wordifier.putDiacriticMarkOnLastVowelInPrefix(
                word = verb,
                prefix = VerbHelper.dropInfinitiveSuffix2SetOfVowelsAndR(verb),
                diacriticMark = AcuteDiacriticMark
            )
    }

    object U_TO_O_Rule : BaseChangingRule {
        val form = PronounNumberGroup(false, true, true, false, false, true)
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = form.hasForm(verbArgs)
        override val fixedVerbList = listOf("sumir")
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            Wordifier.replaceLastFoundGenericLetterInPrefix(
                word = verb,
                prefix = VerbHelper.dropInfinitiveSuffixXR(verb),
                fromGenericLetter = U_Letter,
                toGenericLetter = O_Letter
            )
    }

    object O_TO_U_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override val fixedVerbList = listOf("tossir")
        override fun changeBaseIfPossible(
            verb: String,
            exactSuffix: String,
            verbArgs: VerbArguments,
            verbIsChanged: Boolean
        ): String? =
            Wordifier.replaceLastFoundGenericLetterInPrefix(
                word = verb,
                prefix = VerbHelper.dropInfinitiveSuffixXR(verb),
                fromGenericLetter = O_Letter,
                toGenericLetter = U_Letter
            )
    }


    override val baseChangingRules = listOf(
        C_TO_C_Cedilla_Rule,
        G_TO_J_Rule,
        EGU_TO_IG_Rule,
        E_TO_I_Rule,
        E_TO_I_Full_Rule,
        Construir_Destruir_U_TO_O_Rule,
        GU_TO_G_Rule,
        OIBIR_I_TO_I_Acute_Rule,
        Second_Vowel_From_End_Acute_Rule,
        Third_Vowel_From_End_Acute_Rule,
        U_TO_O_Rule,
        O_TO_U_Rule
    )

    override fun toString(): String {
        return "IndicativePresentTenseConjugator"
    }
}