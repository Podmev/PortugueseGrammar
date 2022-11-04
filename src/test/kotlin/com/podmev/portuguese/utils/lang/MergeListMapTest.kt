package com.podmev.portuguese.utils.lang

import com.google.common.truth.Truth
import org.junit.jupiter.api.Test

class MergeListMapTest {
    @Test
    fun positive() {
        Truth.assertThat(
            mergeListMaps(
                mapOf(
                    Pair("a", listOf("b", "c")),
                    Pair("d", listOf("e"))
                ),
                mapOf(Pair("a", listOf("f")))
            )
        ).isEqualTo(
            mapOf(
                Pair("a", listOf("b", "c", "f")),
                Pair("d", listOf("e"))
            )
        )
    }
}