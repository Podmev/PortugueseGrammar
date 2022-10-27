package com.podmev.portuguese.data.grammar.term.orthography

import com.podmev.portuguese.data.grammar.term.orthography.letters.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AlphabetTest {
    @Test
    fun alphabetLettersAreUniqueTest() {
        val letters: List<Letter> = Alphabet.letters
        Assertions.assertEquals(letters.size, letters.distinct().size, "Letters don't repeat")
    }

    @Test
    fun alphabetLettersQuantity26Test() {
        val letters: List<Letter> = Alphabet.letters
        Assertions.assertEquals(26, letters.size, "Letters don't repeat")
    }

    @Test
    fun vowelTest() {
        val vowels: List<Letter> = Alphabet.vowelLetters
        Assertions.assertEquals(
            /* expected = */ listOf(
                A_Letter,
                E_Letter,
                I_Letter,
                O_Letter,
                U_Letter,
                Y_Letter
            ),
            /* actual = */ vowels,
            /* message = */ "all vowels"
        )
    }

    @Test
    fun consonantTest() {
        val consonants: List<Letter> = Alphabet.consonantLetters
        Assertions.assertEquals(
            /* expected = */ listOf(
                B_Letter,
                C_Letter,
                D_Letter,
                F_Letter,
                G_Letter,
                H_Letter,
                J_Letter,
                K_Letter,
                L_Letter,
                M_Letter,
                N_Letter,
                P_Letter,
                Q_Letter,
                R_Letter,
                S_Letter,
                T_Letter,
                V_Letter,
                W_Letter,
                X_Letter,
                Z_Letter
            ),
            /* actual = */ consonants,
            /* message = */ "all consonants"
        )
    }

}