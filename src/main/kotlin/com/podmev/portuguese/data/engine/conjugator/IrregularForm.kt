package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.RegularTransformation

data class IrregularForm(
    val formGroup: FormGroup? = null,
    //immutable
    val suffixGroup: SuffixGroup? = null,
    val base: String? = null
){
    fun getForm(verbArguments: VerbArguments, regularTransformation: RegularTransformation?): String?{
        //trying formGroup
        val createdByFormGroup = formGroup?.getForm(verbArguments)
        if(createdByFormGroup!=null){
            return  createdByFormGroup
        }
        val irregularSuffix = suffixGroup?.getSuffix(verbArguments)
        if(irregularSuffix==null){
            if(base!=null && regularTransformation!=null){
                return base + regularTransformation.suffix
            }
        } else {
            if(base!=null){
                return base + irregularSuffix
            } else if(regularTransformation!=null){
                return regularTransformation.base + irregularSuffix
            }
        }
        //there is no irregular form
        return null
    }
}

