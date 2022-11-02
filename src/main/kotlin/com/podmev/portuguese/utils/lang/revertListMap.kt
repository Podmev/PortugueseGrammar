package com.podmev.portuguese.utils.lang

fun <K,V> revertListMap(listMap: Map<K, List<V>>): Map<V, K> {
    val resultMap = mutableMapOf<V,K>()

    for ((key, valueList) in listMap){
        for (value in valueList){
            if(resultMap.contains(value)) throw Exception("Multiple value $value")
            resultMap[value] = key
        }
    }
    return resultMap
}