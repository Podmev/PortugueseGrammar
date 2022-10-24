package com.podmev.portuguese.data.grammar.term.general

enum class GrammaticalPerson {
    FIRST,
    SECOND,
    THIRD,
    UNDEFINED;

    companion object {
        val definedList = listOf(FIRST, SECOND, THIRD)
        val undefinedList = listOf(UNDEFINED)

        fun getDefinedList(defined: Boolean): List<GrammaticalPerson> =
            if(defined) definedList else undefinedList
    }
}