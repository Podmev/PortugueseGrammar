package com.podmev.portuguese.data.grammar.term.orthography

import com.google.common.truth.Truth
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.cedilla.C_Cedilla_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.A_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.E_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.grave.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.A_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.tilde.O_Tilde_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.umlaut.U_Umlaut_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AlphabetTest {
    @Nested
    inner class Letters{
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

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#letterProvider")
        fun uppercaseTest(letter: Letter) {
            val firstLetterOfClassName = letter.javaClass.simpleName[0]
            Truth.assertThat(firstLetterOfClassName).isEqualTo(letter.uppercase)
        }

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#letterProvider")
        fun upperAndLowercaseCorrespondenceTest(letter: Letter) {
            Truth.assertThat(letter.uppercase.toLowerCase()).isEqualTo(letter.lowercase)
        }

    }

    @Nested
    inner class DiacriticLetters{
        @Test
        fun diacriticLettersAreUniqueTest() {
            val diacriticLetters: List<DiacriticLetter> = Alphabet.diacriticLetters
            Assertions.assertEquals(diacriticLetters.size, diacriticLetters.distinct().size, "Diacritic letters don't repeat")
        }

        @Test
        fun obsoleteDiacriticLettersTest() {
            val diacriticLetters: List<DiacriticLetter> = Alphabet.diacriticLetters
            val obsoleteDiacriticLetters = diacriticLetters.filter(DiacriticLetter::obsolete)
            Assertions.assertEquals(
                /* expected = */ listOf(
                    E_Grave_Letter,
                    I_Grave_Letter,
                    U_Grave_Letter,

                    U_Umlaut_Letter
                ),
                /* actual = */ obsoleteDiacriticLetters,
                /* message = */ "Obsolete diacritic letters"
            )
        }

        @Test
        fun notObsoleteDiacriticLettersTest() {
            val diacriticLetters: List<DiacriticLetter> = Alphabet.diacriticLetters
            val notObsoleteDiacriticLetters = diacriticLetters.filter{!it.obsolete()}
            Assertions.assertEquals(
                /* expected = */ listOf(
                    A_Acute_Letter,
                    A_Circumflex_Letter,
                    A_Grave_Letter,
                    A_Tilde_Letter,

                    C_Cedilla_Letter,

                    E_Acute_Letter,
                    E_Circumflex_Letter,

                    I_Acute_Letter,

                    O_Acute_Letter,
                    O_Circumflex_Letter,
                    O_Grave_Letter,
                    O_Tilde_Letter,

                    U_Acute_Letter
                ),
                /* actual = */ notObsoleteDiacriticLetters,
                /* message = */ "Not obsolete diacritic letters"
            )
        }

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#diacriticLetterProvider")
        fun uppercaseTest(diacriticLetter: DiacriticLetter) {
            val firstLetterOfClassName = diacriticLetter.javaClass.simpleName[0]
            Truth.assertThat(firstLetterOfClassName).isEqualTo(diacriticLetter.baseLetter.uppercase)
        }

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#diacriticLetterProvider")
        fun upperAndLowercaseCorrespondenceTest(diacriticLetter: DiacriticLetter) {
            Truth.assertThat(diacriticLetter.uppercase.toLowerCase()).isEqualTo(diacriticLetter.lowercase)
        }

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#diacriticLetterProvider")
        fun diacriticMarkTest(diacriticLetter: DiacriticLetter) {
            val secondPartOfName = diacriticLetter.javaClass.simpleName.split("_")[1]
            Truth.assertThat(secondPartOfName).isEqualTo(diacriticLetter.diacriticMark.shortEnglishTerm)
        }

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#diacriticLetterProvider")
        fun diacriticLetterCorrespondenceToLetterTest(diacriticLetter: DiacriticLetter) {
            Truth.assertThat(diacriticLetter.baseLetter.relatedDiacriticLetters.contains(diacriticLetter)).isTrue()
        }

        @ParameterizedTest()
        @MethodSource("com.podmev.portuguese.data.grammar.term.orthography.AlphabetTest#letterProvider")
        fun letterCorrespondenceToDiacriticLettersTest(letter: Letter) {
            Truth.assertThat(
                letter.relatedDiacriticLetters.all{diacriticLetter ->  diacriticLetter.baseLetter == letter}
            ).isTrue()
        }
    }

    companion object {
        @JvmStatic
        fun letterProvider(): Stream<Arguments> =
            Alphabet.letters.stream().map{letter->Arguments.of(letter)}

        @JvmStatic
        fun diacriticLetterProvider(): Stream<Arguments> =
            Alphabet.diacriticLetters.stream().map{letter->Arguments.of(letter)}

    }

}