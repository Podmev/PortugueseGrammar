package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CedillaDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.C_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.G_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.J_Letter
import com.podmev.portuguese.engine.utils.verb.VerbBaseEnds
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

object VerbHelper {
    /*drop the last letter 'r' of infinitive*/
    fun dropInfinitiveSuffixR(infinitive: String): String = infinitive.dropLast(1)

    /*drop the last 2 letters of infinitive: ar, er, ir*/
    fun dropInfinitiveSuffixXR(infinitive: String): String = infinitive.dropLast(2)

    /*drop the last letter 'o' of */
    fun dropSuffixO(infinitive: String): String = infinitive.dropLast(1)

    private val uirEndingExceptions = listOf(
        VerbEnds.GUIR,
        VerbEnds.QUIR
    )

    fun replaceIfNecessaryLastI_LetterForI_Acute_LetterOrNull(infinitive: String): String? {
        if (infinitive.endsWith(VerbEnds.UIR)) {
            if (Wordifier.endsWithAny(infinitive, uirEndingExceptions)) {
                //in this case rule doesn't work
                return infinitive
            }
            //change last 'i' for 'í': with acute accent (acento agudo)
            return Wordifier.addDiacriticsToLastFoundLetter(infinitive, I_Letter, AcuteDiacriticMark)
        }
        if (infinitive.endsWith(VerbEnds.AIR)) {
            //change last 'i' for 'í': with acute accent (acento agudo)
            return Wordifier.addDiacriticsToLastFoundLetter(infinitive, I_Letter, AcuteDiacriticMark)
        }
        return null //not this case
    }

    /*only in correct form of person and number (first-singular)*/
    fun replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull(infinitive: String): String? {
        if (infinitive.endsWith(VerbEnds.CER)) {
            return Wordifier.addDiacriticsToLastFoundLetter(infinitive, C_Letter, CedillaDiacriticMark)
        }
        return null //not this case
    }

    /*only in correct form of person and number (first-singular)*/
    fun replaceIfNecessaryG_LetterForJ_LetterOrNull(infinitive: String): String? {
        if (infinitive.endsWith(VerbEnds.GIR)) {
            return Wordifier.replaceLastFoundGenericLetter(infinitive, G_Letter, J_Letter)
        }
        return null //not this case
    }
}