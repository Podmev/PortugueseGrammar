package com.podmev.portuguese.utils.lang

fun <T> List<T>.paired(): List<Pair<T, T>> {
    val list1 = this
    val list2 = list1.drop(1)
    return list1.zip(list2)
}