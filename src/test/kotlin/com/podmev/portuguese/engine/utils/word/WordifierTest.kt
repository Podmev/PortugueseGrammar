package com.podmev.portuguese.engine.utils.word

import com.google.common.truth.Truth
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.P_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.R_Letter
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WordifierTest {
    @Nested
    inner class AddDiacriticsToLastFoundLetter {
        @Test
        fun positiveTest() {
            Truth.assertThat(Wordifier.addDiacriticsToLastFoundLetter("instituir", I_Letter, AcuteDiacriticMark) )
                .isEqualTo("instituír")
        }
    }

    @Nested
    inner class DeleteLastDiacritics {
        @Test
        fun positiveTest() {
            Truth.assertThat(Wordifier.deleteLastDiacritics("instituír") )
                .isEqualTo("instituir")
        }
    }

    @Nested
    inner class DeleteAllDiacriticMarks {
        @Test
        fun positiveTest() {
            Truth.assertThat(Wordifier.deleteAllDiacriticMarks("instituír") )
                .isEqualTo("instituir")
        }

        @Test
        fun emptyTest() {
            Truth.assertThat(Wordifier.deleteAllDiacriticMarks("instituir") )
                .isEqualTo("instituir")
        }

        @Test
        fun tripleTest() {
            Truth.assertThat(Wordifier.deleteAllDiacriticMarks("ínstítuir") )
                .isEqualTo("instituir")
        }
    }

    @Nested
    inner class ReplaceLastFoundGenericLetter {
        @Test
        fun positiveTest() {
            Truth.assertThat(Wordifier.replaceLastFoundGenericLetter("instituir", I_Letter, I_Acute_Letter) )
                .isEqualTo("instituír")
        }
    }

    @Nested
    inner class Word2ExactLetters {
        @Test
        fun positiveTest() {
            Truth.assertThat(Wordifier.word2ExactLetters("Pôr"))
                .isEqualTo(
                    listOf(
                        P_Letter.uppercaseExactLetter(),
                        O_Circumflex_Letter.lowercaseExactLetter(),
                        R_Letter.lowercaseExactLetter()
                    )
                )
        }
    }

    @Nested
    inner class ExactLetters2Word {
        @Test
        fun positiveTest() {
            Truth.assertThat(
                Wordifier.exactLetters2Word(
                    listOf(
                        P_Letter.uppercaseExactLetter(),
                        O_Circumflex_Letter.lowercaseExactLetter(),
                        R_Letter.lowercaseExactLetter()
                    )
                )
            ).isEqualTo("Pôr")
        }
    }
}