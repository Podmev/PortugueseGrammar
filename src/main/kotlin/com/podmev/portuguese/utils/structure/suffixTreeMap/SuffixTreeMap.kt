package com.podmev.portuguese.utils.structure.suffixTreeMap

interface SuffixTreeMap<T> : Map<String, T> {
    fun findLongestSuffix(word: String): String
}

interface MutableSuffixTreeMap<T> : MutableMap<String, T>, SuffixTreeMap<T> {
}

fun <T> suffixTreeMapOf(entries: Map<String, T>): SuffixTreeMap<T> {
    val tree = DefaultSuffixTreeMap<T>()
    tree.putAll(entries)
    return tree
}

public fun <T> suffixTreeMapOf(vararg pairs: Pair<String, T>): SuffixTreeMap<T> =
    if (pairs.isNotEmpty()) suffixTreeMapOf(pairs.toMap()) else emptySuffixTreeMap()




