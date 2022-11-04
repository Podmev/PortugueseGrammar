package com.podmev.portuguese.data.engine.conjugator

data class VerbWithFormGroup(
    val verb: String,
    val formGroup: FormGroup
){
    override fun toString(): String {
        return "VerbWithFormGroup(verb='$verb', formGroup=$formGroup)"
    }
}
