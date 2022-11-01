package com.podmev.portuguese.utils.structure.suffixtree

import com.google.common.truth.Truth
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class DefaultSuffixTreeTest {
    @Nested
    inner class Entries {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().entries)
                .isEqualTo(emptySet<MutableMap.MutableEntry<String, Int>>())

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.entries)
                .isEqualTo(
                    setOf<MutableMap.MutableEntry<String, Int>>(
                        DefaultSuffixTree.NodeData("abc", 1)
                    )
                )
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            Truth.assertThat(suffixTree.entries)
                .isEqualTo(
                    setOf<MutableMap.MutableEntry<String, Int>>(
                        DefaultSuffixTree.NodeData("abc", 1),
                        DefaultSuffixTree.NodeData("def", 2),
                    )
                )
        }
    }

    @Nested
    inner class Keys {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().keys)
                .isEqualTo(emptySet<String>())

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.keys).isEqualTo(setOf("abc"))
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            Truth.assertThat(suffixTree.keys)
                .isEqualTo(
                    setOf<String>("abc", "def")
                )
        }
    }

    @Nested
    inner class Size {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().size)
                .isEqualTo(0)

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.size).isEqualTo(1)
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            Truth.assertThat(suffixTree.size).isEqualTo(2)
        }
    }

    @Nested
    inner class Values {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().values)
                .isEqualTo(emptyList<Int>())

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.values).isEqualTo(listOf(1))
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            Truth.assertThat(suffixTree.values).isEqualTo(listOf(1, 2))
        }
    }

    @Nested
    inner class Clear {
        @Test
        fun empty() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.clear()
            Truth.assertThat(suffixTree.size)
                .isEqualTo(0)
        }

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree.clear()
            Truth.assertThat(suffixTree.size).isEqualTo(0)
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            suffixTree.clear()
            Truth.assertThat(suffixTree.size).isEqualTo(0)
        }
    }

    @Nested
    inner class ContainsKey {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().containsKey("abc"))
                .isFalse()

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.containsKey("abc")).isTrue()
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            assertAll(
                { Truth.assertThat(suffixTree.containsKey("abc")).isTrue() },
                { Truth.assertThat(suffixTree.containsKey("def")).isTrue() }
            )
        }
    }

    @Nested
    @Suppress("ReplaceGetOrSet")
    inner class Get {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().get("abc"))
                .isNull()

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.get("abc")).isEqualTo(1)
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            assertAll(
                { Truth.assertThat(suffixTree.get("abc")).isEqualTo(1) },
                { Truth.assertThat(suffixTree.get("def")).isEqualTo(2) }
            )
        }
    }

    @Nested
    inner class IsEmpty {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().isEmpty())
                .isTrue()

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.isEmpty()).isFalse()
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            Truth.assertThat(suffixTree.isEmpty()).isFalse()
        }
    }

    @Nested
    inner class Remove {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().remove("abc"))
                .isNull()

        @Test
        fun onePutOneRemove() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            val oldValue = suffixTree.remove("abc")
            assertAll(
                { Truth.assertThat(oldValue).isEqualTo(1) },
                { Truth.assertThat(suffixTree.size).isEqualTo(0) }
            )
        }

        @Test
        fun twoPutSameBranchOneRemove() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["abcdef"] = 2
            val oldValue = suffixTree.remove("abcdef")
            assertAll(
                { Truth.assertThat(oldValue).isEqualTo(2) },
                { Truth.assertThat(suffixTree.size).isEqualTo(1) }
            )
        }

        @Test
        fun twoPutDifferentBranchOneRemove() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            val oldValue = suffixTree.remove("def")
            assertAll(
                { Truth.assertThat(oldValue).isEqualTo(2) },
                { Truth.assertThat(suffixTree.size).isEqualTo(1) }
            )
        }
    }

    @Nested
    inner class PutAll {
        @Test
        fun threeValuesSize() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.putAll(
                mapOf(
                    Pair("abc", 1),
                    Pair("abd", 2),
                    Pair("ac", 3)
                )
            )
            Truth.assertThat(suffixTree.size)
                .isEqualTo(3)
        }
    }

    @Suppress("ReplacePutWithAssignment")
    @Nested
    inner class Put {
        @Test
        fun oneValueSize() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.put("abc", 1)
            Truth.assertThat(suffixTree.size)
                .isEqualTo(1)
        }

        @Test
        fun oneAndOneValuesSize() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree.put("abc", 1)
            suffixTree.put("abd", 2)
            Truth.assertThat(suffixTree.size)
                .isEqualTo(2)
        }

        @Test
        fun oneValuesContainsAndGet() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree()
            suffixTree.put("abc", 1)
            suffixTree.put("abd", 2)
            assertAll(
                "two entries",
                { Truth.assertThat(suffixTree.containsKey("abc")).isTrue() },
                { Truth.assertThat(suffixTree.containsKey("abd")).isTrue() },
                { Truth.assertThat(suffixTree.containsValue(1)).isTrue() },
                { Truth.assertThat(suffixTree.containsValue(2)).isTrue() },
                { Truth.assertThat(suffixTree["abc"]).isEqualTo(1) },
                { Truth.assertThat(suffixTree["abd"]).isEqualTo(2) },
            )
        }

        @Test
        fun doubleSameKey() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree()
            val key = "abc"
            suffixTree.put(key, 1)
            suffixTree.put(key, 2)
            assertAll(
                "two entries",
                { Truth.assertThat(suffixTree.size).isEqualTo(1) },
                { Truth.assertThat(suffixTree.containsValue(1)).isFalse() },
                { Truth.assertThat(suffixTree[key]).isEqualTo(2) },
            )
        }

        @Test
        fun every3Letters() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree()
            for (c1 in 'a'..'z') {
                for (c2 in 'a'..'z') {
                    for (c3 in 'a'..'z') {
                        suffixTree.put("$c1$c2$c3", 1)
                    }
                }
            }
            Truth.assertThat(suffixTree.size).isEqualTo(26 * 26 * 26)
        }
    }

    @Nested
    inner class ContainsValue {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().containsValue(3))
                .isFalse()

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            Truth.assertThat(suffixTree.containsValue(1)).isTrue()
        }

        @Test
        fun twoPut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["abc"] = 1
            suffixTree["def"] = 2
            assertAll(
                { Truth.assertThat(suffixTree.containsValue(1)).isTrue() },
                { Truth.assertThat(suffixTree.containsValue(2)).isTrue() }
            )
        }

    }

    @Nested
    inner class SuffixTreeOf() {
        @Test
        fun threeValuesSize() {
            val suffixTree: SuffixTree<Int> = suffixTreeOf(
                mapOf(
                    Pair("abc", 1),
                    Pair("abd", 2),
                    Pair("ac", 3)
                )
            )
            Truth.assertThat(suffixTree.size)
                .isEqualTo(3)
        }
    }

    //specific api

    @Nested
    inner class FindLongestSuffix {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTree<Int>().findLongestSuffix("abc"))
                .isEqualTo("")

        @Test
        fun onePut() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["cba"] = 1
            Truth.assertThat(suffixTree.findLongestSuffix("fedcba")).isEqualTo("cba")
        }

        @Test
        fun twoSameBranch() {
            val suffixTree: MutableSuffixTree<Int> = DefaultSuffixTree<Int>()
            suffixTree["cba"] = 1
            suffixTree["fedcba"] = 2
            Truth.assertThat(suffixTree.findLongestSuffix("ghfedcba")).isEqualTo("fedcba")
        }
    }
}