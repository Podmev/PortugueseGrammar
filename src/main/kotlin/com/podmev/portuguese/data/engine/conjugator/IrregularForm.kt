package com.podmev.portuguese.data.engine.conjugator

data class IrregularForm(
    val formGroup: FormGroup? = null,
    //immutable
    val base: String? = null,
    val suffixGroup: SuffixGroup? = null
)

