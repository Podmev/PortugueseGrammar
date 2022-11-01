package com.podmev.portuguese.utils.structure.suffixtree

import com.google.common.truth.Truth
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DefaultSuffixTreeTest {
    @Nested
    inner class Entries{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().entries)
                .isEqualTo(emptySet<MutableMap.MutableEntry<String, Int>>())
    }

    @Nested
    inner class Keys{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().keys)
                .isEqualTo(emptySet<String>())
    }

    @Nested
    inner class Size{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().size)
                .isEqualTo(0)

    }

    @Nested
    inner class Values{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().values)
                .isEqualTo(emptyList<Int>())
    }

    @Nested
    inner class Clear{
        @Test
        fun empty() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.clear()
            Truth.assertThat(suffixTree.size)
                .isEqualTo(0)
        }
    }

    @Nested
    inner class ContainsKey{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().containsKey("abc"))
                .isFalse()
    }

    @Nested
    @Suppress("ReplaceGetOrSet")
    inner class Get{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().get("abc"))
                .isNull()
    }

    @Nested
    inner class IsEmpty{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().isEmpty())
                .isTrue()
    }

    @Nested
    inner class Remove{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().remove("abc"))
                .isNull()
    }

    @Nested
    inner class PutAll{
        @Test
        fun threeValuesSize() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.putAll(mapOf(
                Pair("abc", 1),
                Pair("abd", 2),
                Pair("ac", 3))
            )
            Truth.assertThat(suffixTree.size)
                .isEqualTo(3)
        }
    }

    @Suppress("ReplacePutWithAssignment")
    @Nested
    inner class Put{
        @Test
        fun oneValueSize() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.put("abc", 1)
            Truth.assertThat(suffixTree.size)
                .isEqualTo(1)
        }
    }

    @Nested
    inner class ContainsValue{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().containsValue(3))
                .isFalse()
    }

    //specific api

    @Nested
    inner class FindLongestSuffix{
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().findLongestSuffix("abc"))
                .isEqualTo("")
    }
}