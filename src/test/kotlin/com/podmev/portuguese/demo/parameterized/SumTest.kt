package com.podmev.portuguese.demo.parameterized

import com.google.common.truth.Truth
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class SumTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("sumProvider")
    fun sum(a: Int, b: Int, expected: Int) {
        Truth.assertThat((a + b)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun sumProvider(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(1, 2, 3),
                    Arguments.of(5, 10, 15)
            )
        }
    }
}