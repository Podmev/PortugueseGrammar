package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.data.engine.conjugator.SuffixGroup

data class RegularTransformation(
    val regularForm: String,
    val base: String,
    val suffix: String,
    val suffixGroup: SuffixGroup
){
    override fun toString(): String {
        return "RegularTransformation(regularForm='$regularForm', base='$base', suffix='$suffix', suffixGroup=$suffixGroup)"
    }
}
