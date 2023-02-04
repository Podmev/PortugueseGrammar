package com.podmev.portuguese.data.engine.conjugator

import ExtendedPronounVerbForm

/*for short usage*/
typealias L = ListPronounVerbForm

class ListPronounVerbForm(
    vararg val versions: String
) {
    fun isEmpty() = versions.isEmpty()
    fun isNotEmpty() = !isEmpty()

    fun toExtended()=
        ExtendedPronounVerbForm(versions.toList(), versions.toList())
}

fun createListFormGroupByString(str: String?): ListPronounVerbForm? =
    if (str != null) ListPronounVerbForm(str) else null

