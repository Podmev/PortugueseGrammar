package com.podmev.portuguese.utils.lang

fun <T> List<T>.getFromEnd(index: Int) =
    get(lastIndex-index)