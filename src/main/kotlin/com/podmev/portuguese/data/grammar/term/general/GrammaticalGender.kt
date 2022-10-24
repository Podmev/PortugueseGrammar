package com.podmev.portuguese.data.grammar.term.general

enum class GrammaticalGender {
    MASCULINE,
    FEMININE,
    UNDEFINED;

    companion object {
        val definedList = listOf(
            MASCULINE,
            FEMININE
        )
        val undefinedList = listOf(UNDEFINED)

        fun getDefinedList(defined: Boolean): List<GrammaticalGender> =
            if(defined) definedList else undefinedList
    }
}