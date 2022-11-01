package com.podmev.portuguese.utils.structure.suffixtree

interface SuffixTree<T> : Map<String, T> {
    fun findLongestSuffix(word: String): String
}

interface MutableSuffixTree<T> : MutableMap<String, T>, SuffixTree<T> {
}

fun <T> suffixTreeOf(entries: Map<String, T>): SuffixTree<T> {
    val tree = DefaultSuffixTree<T>()
    tree.putAll(entries)
    return tree
}




