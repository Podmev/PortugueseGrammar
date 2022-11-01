package com.podmev.portuguese.utils.structure.suffixtree

object EmptySuffixTree : SuffixTree<Any?> {
    override fun equals(other: Any?): Boolean = other is SuffixTree<*> && other.isEmpty()
    override fun hashCode(): Int = 0
    override fun toString(): String = "{}"

    override val size: Int get() = 0
    override fun isEmpty(): Boolean = true

    override fun containsKey(key: String): Boolean = false
    override fun containsValue(value: Any?): Boolean = false
    override fun get(key: String): Nothing? = null
    override val entries: Set<Map.Entry<String, Nothing>> get() = emptySet()
    override val keys: Set<String> get() = emptySet()
    override val values: Collection<Nothing> get() = emptyList()

    override fun findLongestSuffix(word: String): String = ""
}

fun <T> emptySuffixTree(): SuffixTree<T> = @Suppress("UNCHECKED_CAST") (EmptySuffixTree as SuffixTree<T>)