package com.podmev.portuguese.data.grammar.term.orthography

import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory.CONSONANT
import com.podmev.portuguese.data.grammar.term.orthography.LetterCategory.VOWEL
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
    val vowelLetters = letters.filter { it.category == VOWEL }
    val consonantLetters = letters.filter { it.category == CONSONANT }

}