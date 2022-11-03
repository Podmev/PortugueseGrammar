package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.grammar.term.orthography.Alphabet
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.CedillaDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.*
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

object VerbHelper {
    /*drop the last letter 'r' of infinitive*/
    fun dropInfinitiveSuffixR(infinitive: String): String = dropInfinitiveSuffixByLength(infinitive, 1)

    /*drop the last 2 letters of infinitive: ar, er, ir*/
    fun dropInfinitiveSuffixXR(infinitive: String): String = dropInfinitiveSuffixByLength(infinitive, 2)

    /*drop the last several letters of infinitive: usually 2, but in some cases 3 (iar)*/
    fun dropInfinitiveSuffixByLength(infinitive: String, lengthToDrop: Int): String = infinitive.dropLast(lengthToDrop)

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

    /*only in correct form of person and number (first-singular)*/
    fun replaceIfNecessaryE_LetterForI_LetterOrNull(infinitive: String): String? {
        if (infinitive.endsWith(VerbEnds.IR) &&
            infinitive.contains(E_Letter.lowercase) &&
            dropInfinitiveSuffixXR(infinitive).findLast { Alphabet.isVowelChar(it) } == E_Letter.lowercase //checking last vowel of base is e
        ) {
            return Wordifier.replaceLastFoundGenericLetter(infinitive, E_Letter, I_Letter)
        }
        return null //not this case
    }

    /*only in correct form of person and number (first-singular)*/
    fun replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull(infinitive: String): String? {
        if (infinitive.endsWith(VerbEnds.EGUIR)) {
            return Wordifier.replaceEnding(infinitive, VerbEnds.EGUIR, VerbEnds.IGIR)
        }
        return null
    }

    fun diffVerbAndOrigin(verb: String, originIrregularVerb: String): String {
        val verbWithoutDiacritics = Wordifier.deleteAllDiacriticMarks(verb)
        val originWithoutDiacritics = Wordifier.deleteAllDiacriticMarks(originIrregularVerb)
        for (i in 0..originWithoutDiacritics.length) {
            if (verbWithoutDiacritics.endsWith(originWithoutDiacritics.drop(i))) {
                return verbWithoutDiacritics.dropLast(originWithoutDiacritics.length - i)
            }
        }
        throw Exception("Unreachable code")
    }
}