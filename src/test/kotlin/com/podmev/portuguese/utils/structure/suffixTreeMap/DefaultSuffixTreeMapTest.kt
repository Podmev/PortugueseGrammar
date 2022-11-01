package com.podmev.portuguese.utils.structure.suffixTreeMap

import com.google.common.truth.Truth
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class DefaultSuffixTreeMapTest {
    @Nested
    inner class Entries {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().entries)
                .isEqualTo(emptySet<MutableMap.MutableEntry<String, Int>>())

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.entries)
                .isEqualTo(
                    setOf<MutableMap.MutableEntry<String, Int>>(
                        DefaultSuffixTreeMap.NodeData("abc", 1)
                    )
                )
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            Truth.assertThat(suffixTreeMap.entries)
                .isEqualTo(
                    setOf<MutableMap.MutableEntry<String, Int>>(
                        DefaultSuffixTreeMap.NodeData("abc", 1),
                        DefaultSuffixTreeMap.NodeData("def", 2),
                    )
                )
        }
    }

    @Nested
    inner class Keys {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().keys)
                .isEqualTo(emptySet<String>())

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.keys).isEqualTo(setOf("abc"))
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            Truth.assertThat(suffixTreeMap.keys)
                .isEqualTo(
                    setOf<String>("abc", "def")
                )
        }
    }

    @Nested
    inner class Size {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().size)
                .isEqualTo(0)

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.size).isEqualTo(1)
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            Truth.assertThat(suffixTreeMap.size).isEqualTo(2)
        }
    }

    @Nested
    inner class Values {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().values)
                .isEqualTo(emptyList<Int>())

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.values).isEqualTo(listOf(1))
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            Truth.assertThat(suffixTreeMap.values).isEqualTo(listOf(1, 2))
        }
    }

    @Nested
    inner class Clear {
        @Test
        fun empty() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap.clear()
            Truth.assertThat(suffixTreeMap.size)
                .isEqualTo(0)
        }

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap.clear()
            Truth.assertThat(suffixTreeMap.size).isEqualTo(0)
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            suffixTreeMap.clear()
            Truth.assertThat(suffixTreeMap.size).isEqualTo(0)
        }
    }

    @Nested
    inner class ContainsKey {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().containsKey("abc"))
                .isFalse()

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.containsKey("abc")).isTrue()
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            assertAll(
                { Truth.assertThat(suffixTreeMap.containsKey("abc")).isTrue() },
                { Truth.assertThat(suffixTreeMap.containsKey("def")).isTrue() }
            )
        }
    }

    @Nested
    @Suppress("ReplaceGetOrSet")
    inner class Get {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().get("abc"))
                .isNull()

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.get("abc")).isEqualTo(1)
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            assertAll(
                { Truth.assertThat(suffixTreeMap.get("abc")).isEqualTo(1) },
                { Truth.assertThat(suffixTreeMap.get("def")).isEqualTo(2) }
            )
        }
    }

    @Nested
    inner class IsEmpty {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().isEmpty())
                .isTrue()

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.isEmpty()).isFalse()
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            Truth.assertThat(suffixTreeMap.isEmpty()).isFalse()
        }
    }

    @Nested
    inner class Remove {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().remove("abc"))
                .isNull()

        @Test
        fun onePutOneRemove() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            val oldValue = suffixTreeMap.remove("abc")
            assertAll(
                { Truth.assertThat(oldValue).isEqualTo(1) },
                { Truth.assertThat(suffixTreeMap.size).isEqualTo(0) }
            )
        }

        @Test
        fun twoPutSameBranchOneRemove() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["abcdef"] = 2
            val oldValue = suffixTreeMap.remove("abcdef")
            assertAll(
                { Truth.assertThat(oldValue).isEqualTo(2) },
                { Truth.assertThat(suffixTreeMap.size).isEqualTo(1) }
            )
        }

        @Test
        fun twoPutDifferentBranchOneRemove() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            val oldValue = suffixTreeMap.remove("def")
            assertAll(
                { Truth.assertThat(oldValue).isEqualTo(2) },
                { Truth.assertThat(suffixTreeMap.size).isEqualTo(1) }
            )
        }
    }

    @Nested
    inner class PutAll {
        @Test
        fun threeValuesSize() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap.putAll(
                mapOf(
                    Pair("abc", 1),
                    Pair("abd", 2),
                    Pair("ac", 3)
                )
            )
            Truth.assertThat(suffixTreeMap.size)
                .isEqualTo(3)
        }
    }

    @Suppress("ReplacePutWithAssignment")
    @Nested
    inner class Put {
        @Test
        fun oneValueSize() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap.put("abc", 1)
            Truth.assertThat(suffixTreeMap.size)
                .isEqualTo(1)
        }

        @Test
        fun oneAndOneValuesSize() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap.put("abc", 1)
            suffixTreeMap.put("abd", 2)
            Truth.assertThat(suffixTreeMap.size)
                .isEqualTo(2)
        }

        @Test
        fun oneValuesContainsAndGet() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap()
            suffixTreeMap.put("abc", 1)
            suffixTreeMap.put("abd", 2)
            assertAll(
                "two entries",
                { Truth.assertThat(suffixTreeMap.containsKey("abc")).isTrue() },
                { Truth.assertThat(suffixTreeMap.containsKey("abd")).isTrue() },
                { Truth.assertThat(suffixTreeMap.containsValue(1)).isTrue() },
                { Truth.assertThat(suffixTreeMap.containsValue(2)).isTrue() },
                { Truth.assertThat(suffixTreeMap["abc"]).isEqualTo(1) },
                { Truth.assertThat(suffixTreeMap["abd"]).isEqualTo(2) },
            )
        }

        @Test
        fun doubleSameKey() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap()
            val key = "abc"
            suffixTreeMap.put(key, 1)
            suffixTreeMap.put(key, 2)
            assertAll(
                "two entries",
                { Truth.assertThat(suffixTreeMap.size).isEqualTo(1) },
                { Truth.assertThat(suffixTreeMap.containsValue(1)).isFalse() },
                { Truth.assertThat(suffixTreeMap[key]).isEqualTo(2) },
            )
        }

        @Test
        fun every3Letters() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap()
            for (c1 in 'a'..'z') {
                for (c2 in 'a'..'z') {
                    for (c3 in 'a'..'z') {
                        suffixTreeMap.put("$c1$c2$c3", 1)
                    }
                }
            }
            Truth.assertThat(suffixTreeMap.size).isEqualTo(26 * 26 * 26)
        }
    }

    @Nested
    inner class ContainsValue {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().containsValue(3))
                .isFalse()

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            Truth.assertThat(suffixTreeMap.containsValue(1)).isTrue()
        }

        @Test
        fun twoPut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["abc"] = 1
            suffixTreeMap["def"] = 2
            assertAll(
                { Truth.assertThat(suffixTreeMap.containsValue(1)).isTrue() },
                { Truth.assertThat(suffixTreeMap.containsValue(2)).isTrue() }
            )
        }

    }

    @Nested
    inner class SuffixTreeMapOf() {
        @Test
        fun threeValuesSize() {
            val suffixTreeMap: SuffixTreeMap<Int> = suffixTreeMapOf(
                mapOf(
                    Pair("abc", 1),
                    Pair("abd", 2),
                    Pair("ac", 3)
                )
            )
            Truth.assertThat(suffixTreeMap.size)
                .isEqualTo(3)
        }
    }

    //specific api

    @Nested
    inner class FindLongestSuffix {
        @Test
        fun empty() =
            Truth.assertThat(DefaultSuffixTreeMap<Int>().findLongestSuffix("abc"))
                .isNull()

        @Test
        fun onePut() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["cba"] = 1
            Truth.assertThat(suffixTreeMap.findLongestSuffix("fedcba")).isEqualTo("cba")
        }

        @Test
        fun negative() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["cba"] = 1
            Truth.assertThat(suffixTreeMap.findLongestSuffix("dba")).isNull()
        }

        @Test
        fun twoSameBranch() {
            val suffixTreeMap: MutableSuffixTreeMap<Int> = DefaultSuffixTreeMap<Int>()
            suffixTreeMap["cba"] = 1
            suffixTreeMap["fedcba"] = 2
            Truth.assertThat(suffixTreeMap.findLongestSuffix("ghfedcba")).isEqualTo("fedcba")
        }
    }
}