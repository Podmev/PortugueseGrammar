package com.podmev.portuguese.data.engine.conjugator

data class IrregularForm(
    val formGroup: FormGroup? = null,
    //immutable
    val suffixGroup: SuffixGroup? = null,
    val base: String? = null
)

