package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup

data class RegularTransformation(
    val regularForm: String,
    val base: String,
    val suffix: String,
    val suffixGroup: SuffixGroup
)
