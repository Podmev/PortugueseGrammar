package com.podmev.portuguese.utils.lang

import com.google.common.truth.Truth
import org.junit.jupiter.api.Test

class PairedTest {
    @Test
    fun simple3Test(){
        Truth.assertThat(listOf(1, 2, 3).paired())
            .isEqualTo(listOf(Pair(1, 2), Pair(2, 3)))
    }

    @Test
    fun simple2Test(){
        Truth.assertThat(listOf(1, 2).paired())
            .isEqualTo(listOf(Pair(1, 2)))
    }

    @Test
    fun simple1Test(){
        Truth.assertThat(listOf(1).paired())
            .isEqualTo(emptyList<Int>())
    }

    @Test
    fun simple0Test(){
        Truth.assertThat(listOf(1).paired())
            .isEqualTo(emptyList<Int>())
    }
}