package com.podmev.portuguese.utils.structure.suffixtree

interface SuffixTree<T> : Map<String, T> {
    fun findLongestSuffix(word: String): String
}

interface MutableSuffixTree<T> : MutableMap<String, T>, SuffixTree<T> {
}





