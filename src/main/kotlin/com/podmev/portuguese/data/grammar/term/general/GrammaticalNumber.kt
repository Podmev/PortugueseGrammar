package com.podmev.portuguese.data.grammar.term.general

enum class GrammaticalNumber {
    SINGULAR,
    PLURAL,
    UNDEFINED;

    companion object {
        val definedList = listOf(
            SINGULAR,
            PLURAL
        )
        val undefinedList = listOf(UNDEFINED)

        fun getDefinedList(defined: Boolean): List<GrammaticalNumber> =
            if (defined) definedList else undefinedList
    }
}