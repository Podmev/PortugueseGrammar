package com.podmev.portuguese.data.engine.conjugator
//TODO add locale: portugal/brasil
data class ConjugateSettings(
    //usually don't use, so default value is false
    val ignoreDefective: Boolean
)

val defaultConjugateSettings = ConjugateSettings(ignoreDefective = false)

fun allConjugationSettingsCombinations() =
    listOf(
        ConjugateSettings(true),
        ConjugateSettings(false)
    )
