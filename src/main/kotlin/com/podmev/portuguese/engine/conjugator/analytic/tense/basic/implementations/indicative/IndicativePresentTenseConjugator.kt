package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.O_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.U_Letter
import com.podmev.portuguese.data.grammar.term.verb.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryE_LetterForI_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryG_LetterForJ_LetterOrNull
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

object IndicativePresentTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator {
    override val arSuffix = SuffixGroup("o", "as", "a", "amos", "ais", "am")
    override val erSuffix = SuffixGroup("o", "es", "e", "emos", "eis", "em")
    override val irSuffix = SuffixGroup("o", "es", "e", "imos", "is", "em")

    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(IrregularVerbs.SER, IrregularForm(FormGroup("sou", "és", "é", "somos", "sois", "são"))),
        Pair(IrregularVerbs.ESTAR, IrregularForm(FormGroup("estou", "estás", "está", null, null, "estão"))),
        Pair(IrregularVerbs.TER, IrregularForm(FormGroup("tenho", "tens", "tem", "temos", "tendes", "têm"))),
        Pair(IrregularVerbs.HAVER, IrregularForm(FormGroup("hei", "hás", "há", null, null, "hão"))),
        Pair(IrregularVerbs.POR, IrregularForm(FormGroup("ponho", "pões", "põe", "pomos", "pondes", "põem"))),
        Pair(IrregularVerbs.IR, IrregularForm(FormGroup("vou", "vais", "vai", "vamos", "ides", "vão"))),
        Pair(IrregularVerbs.FAZER, IrregularForm(FormGroup("faço", null, "faz", null, null, null))),
        Pair(IrregularVerbs.DIZER, IrregularForm(FormGroup("digo", null, "diz", null, null, null))),
        Pair(IrregularVerbs.PODER, IrregularForm(FormGroup("posso", null, null, null, null, null))),
        Pair(IrregularVerbs.VER, IrregularForm(FormGroup("vejo", "vês", "vê", null, "vedes", "veem"))),
        Pair(IrregularVerbs.DAR, IrregularForm(FormGroup("dou", "dás", "dá", null, null, "dão"))),
        Pair(IrregularVerbs.SABER, IrregularForm(FormGroup("sei", null, null, null, null, null))),
        Pair(IrregularVerbs.VIR, IrregularForm(FormGroup("venho", "vens", "vem", null, "vindes", "vêm"))),
        Pair(IrregularVerbs.QUERER, IrregularForm(FormGroup("venho", "vens", "vem", null, "vindes", "vêm"))),
        Pair(IrregularVerbs.OUVIR, IrregularForm(FormGroup("ouço", null, null, null, null, null))), //ouço ≈ oiço
        Pair(IrregularVerbs.PEDIR, IrregularForm(FormGroup("peço", null, null, null, null, null))),
        Pair(IrregularVerbs.LER, IrregularForm(FormGroup("leio", "lês", "lê", null, "ledes", "leem"))),
        Pair(IrregularVerbs.TRAZER, IrregularForm(FormGroup("trago", null, "traz", null, null, null))),
        Pair(IrregularVerbs.PERDER, IrregularForm(FormGroup("perco", null, null, null, null, null))),
        Pair(IrregularVerbs.DORMIR, IrregularForm(FormGroup("durmo", null, null, null, null, null))),
        Pair(IrregularVerbs.SUBIR, IrregularForm(FormGroup(null, "sobes", "sobe", null, null, "sobem"))), //Think how to make
        Pair(IrregularVerbs.FUGIR, IrregularForm(FormGroup(null, "fobes", "foge", null, null, "fogem"))),//Think how to make
        Pair(IrregularVerbs.RIR, IrregularForm(FormGroup("rio", "ris", "ri", null, "rides", "riem"))),
    )

    object UZIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UZIR
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
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(regularSuffix.singularFirst, "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
        UZIR_Suffix_Rule,
        AIR_Suffix_Rule,
        UIR_Suffix_Rule
    )

    object C_TO_C_Cedilla_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull(verb)
    }

    object G_TO_J_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryG_LetterForJ_LetterOrNull(verb)
    }

    object EGU_TO_IG_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull(verb)
    }

    object E_TO_I_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryE_LetterForI_LetterOrNull(verb)
    }

    object Construir_Destruir_U_TO_O_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isSecondSingular() || verbArgs.isThird()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            if (verb in listOf("construir", "destruir"))
                Wordifier.replaceLastFoundGenericLetter(
                    word = verb,
                    fromGenericLetter = U_Letter,
                    toGenericLetter =
                    if (verbArgs.isThirdPlural())
                        O_Letter
                    else O_Acute_Letter //second-singular and third-singular
                )
            else null
    }

    override val baseChangingRules = listOf(
        C_TO_C_Cedilla_Rule,
        G_TO_J_Rule,
        EGU_TO_IG_Rule,
        E_TO_I_Rule,// - excluded for now
        Construir_Destruir_U_TO_O_Rule
    )

    override fun toString(): String {
        return "IndicativePresentTenseConjugator"
    }
}