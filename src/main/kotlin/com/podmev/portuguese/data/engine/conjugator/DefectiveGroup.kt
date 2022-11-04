package com.podmev.portuguese.data.engine.conjugator

data class DefectiveGroup(
    val singularFirst: Boolean,
    val singularSecond: Boolean,
    val singularThird: Boolean,
    val pluralFirst: Boolean,
    val pluralSecond: Boolean,
    val pluralThird: Boolean
) {
    override fun toString(): String {
        return "DefectiveGroup($singularFirst, $singularSecond, $singularThird, $pluralFirst, $pluralSecond, $pluralThird)"
    }
}


