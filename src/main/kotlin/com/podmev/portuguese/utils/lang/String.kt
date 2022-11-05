package com.podmev.portuguese.utils.lang

fun String.getFromEnd(index: Int): Char =
    get(lastIndex-index)

fun String.prepend(char: Char): String =
    char + this