package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.other.PortugueseLocale

data class ConjugateSettings(
    //usually don't use, so default value is false
    val ignoreDefective: Boolean,
    //brazil or portugal
    val portugueseLocale: PortugueseLocale
)

val defaultConjugateSettings = ConjugateSettings(ignoreDefective = false, portugueseLocale = PortugueseLocale.BRAZIL)

fun allConjugationSettingsCombinations() =
    listOf(
        ConjugateSettings(true, PortugueseLocale.BRAZIL),
        ConjugateSettings(false, PortugueseLocale.BRAZIL),
        ConjugateSettings(true, PortugueseLocale.PORTUGAL),
        ConjugateSettings(false, PortugueseLocale.PORTUGAL)
    )
