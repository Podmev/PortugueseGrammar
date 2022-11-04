package com.podmev.portuguese.utils.lang

fun <K, V> mergeListMaps(listMap1: Map<K, List<V>>, listMap2: Map<K, List<V>>): MutableMap<K, List<V>> {
    val resultMap = mutableMapOf<K, List<V>>()

    val allKeys = listMap1.keys + listMap2.keys

    for (key in allKeys) {
        val list1 = listMap1[key] ?: emptyList()
        val list2 = listMap2[key] ?: emptyList()
        val mergedList = (list1 + list2).distinct()
        resultMap[key] = mergedList
    }
    return resultMap
}