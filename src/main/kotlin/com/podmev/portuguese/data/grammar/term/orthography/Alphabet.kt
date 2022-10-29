package com.podmev.portuguese.data.grammar.term.orthography

import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory.CONSONANT
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory.VOWEL
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.cedilla.C_Cedilla_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.A_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.E_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.A_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.O_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.umlaut.U_Umlaut_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.*
import com.podmev.portuguese.data.grammar.term.orthography.letters.*

object Alphabet {
    val letters = listOf(
        A_Letter,
        B_Letter,
        C_Letter,
        D_Letter,
        E_Letter,
        F_Letter,
        G_Letter,
        H_Letter,
        I_Letter,
        J_Letter,
        K_Letter,
        L_Letter,
        M_Letter,
        N_Letter,
        O_Letter,
        P_Letter,
        Q_Letter,
        R_Letter,
        S_Letter,
        T_Letter,
        V_Letter,
        U_Letter,
        W_Letter,
        X_Letter,
        Y_Letter,
        Z_Letter
    )
    val vowelLetters = letters.filter { it.category() == VOWEL }
    val consonantLetters = letters.filter { it.category() == CONSONANT }

    val diacriticLetters: List<DiacriticLetter> = listOf(
        A_Acute_Letter,
        A_Circumflex_Letter,
        A_Grave_Letter,
        A_Tilde_Letter,

        C_Cedilla_Letter,

        E_Acute_Letter,
        E_Circumflex_Letter,
        E_Grave_Letter,

        I_Acute_Letter,
        I_Grave_Letter,

        O_Acute_Letter,
        O_Circumflex_Letter,
        O_Grave_Letter,
        O_Tilde_Letter,

        U_Acute_Letter,
        U_Grave_Letter,
        U_Umlaut_Letter
    )

    val diacriticMarks: List<DiacriticMark> = listOf(
        AcuteDiacriticMark,
        CedillaDiacriticMark,
        CircumflexDiacriticMark,
        GraveDiacriticMark,
        TildeDiacriticMark,
        UmlautDiacriticMark
    )

    val genericLetters: List<GenericLetter> = letters + diacriticLetters
    val vowelGenericLetters = genericLetters.filter { it.category() == VOWEL }
    val consonantGenericLetters = genericLetters.filter { it.category() == CONSONANT }

    val exactLetters: List<ExactLetter> = genericLetters.flatMap { it.allExactLetters() }
    val vowelExactLetters: List<ExactLetter> = exactLetters.filter { it.genericLetter.category() == VOWEL }
    val consonantExactLetters: List<ExactLetter> = exactLetters.filter { it.genericLetter.category() == CONSONANT }

    //TODO rename possibleChars
    val possibleChars: List<Char> = exactLetters.map { it.view }
    val vowelChars: List<Char> = vowelExactLetters.map { it.view }
    val consonantChars: List<Char> = consonantExactLetters.map { it.view }

    fun isVowelChar(c: Char) = c in vowelChars
    fun isConsonantChar(c: Char) = c in consonantChars

    private val exactLetterViewMap: Map<Char, ExactLetter> = exactLetters.associateBy { it.view }
    fun parseExactLetter(c: Char): ExactLetter? = exactLetterViewMap[c]

}