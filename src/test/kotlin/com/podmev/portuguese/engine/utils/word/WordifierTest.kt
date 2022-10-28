package com.podmev.portuguese.engine.utils.word

import com.google.common.truth.Truth
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.circumflex.O_Circumflex_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.P_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.R_Letter
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WordifierTest {
    @Nested
    inner class AddDiacriticsToLastFoundLetter {

    }

    @Nested
    inner class DeleteLastDiacritics {

    }

    @Nested
    inner class ReplaceLastFoundGenericLetter {

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