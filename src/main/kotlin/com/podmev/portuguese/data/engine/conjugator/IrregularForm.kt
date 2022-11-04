package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.RegularTransformation

data class IrregularForm(
    val formGroup: FormGroup? = null,
    //immutable
    val suffixGroup: SuffixGroup? = null,
    val baseGroup: BaseGroup? = null
){
    fun getForm(verbArguments: VerbArguments, regularTransformation: RegularTransformation?): List<String>?{
        //trying formGroup
        val createdByFormGroup = formGroup?.getForm(verbArguments)
        if(createdByFormGroup!=null){
            return listOf(createdByFormGroup)
        }
        val irregularSuffix = suffixGroup?.getSuffix(verbArguments)
        val irregularBase = baseGroup?.getBase(verbArguments)
        if(irregularSuffix==null){
            if(irregularBase!=null && regularTransformation!=null){
                return listOf(irregularBase + regularTransformation.suffix)
            }
        } else {
            if(irregularBase!=null){
                return listOf(irregularBase + irregularSuffix)
            } else if(regularTransformation!=null){
                return listOf(regularTransformation.base + irregularSuffix)
            }
        }
        //there is no irregular form
        return null
    }
}

