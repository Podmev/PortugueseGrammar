package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.other.PortugueseLocale
import com.podmev.portuguese.engine.conjugator.analytic.RegularTransformation

/*
can be used maximum one of formGroup/listFormGroup/extendedFormGroup
* */
data class IrregularForm(
    val formGroup: FormGroup? = null,
    val suffixGroup: SuffixGroup? = null,
    val baseGroup: BaseGroup? = null,
    val base: String? = null,
    val listFormGroup: ListFormGroup? = null,
    val extendedFormGroup: ExtendedFormGroup? = null
) {
    private val updatedExtendedFormGroup =
        formGroup?.convertToExtended()
            ?: listFormGroup?.convertToExtended()
            ?: extendedFormGroup

    init {
        if (listOfNotNull(formGroup, listFormGroup, extendedFormGroup).size > 1) {
            throw Exception(
                "Defined more then 1 form group: " +
                        "formGroup = $formGroup, listFormGroup=$listFormGroup, extendedFormGroup = $extendedFormGroup"
            )
        }
    }

    fun getForm(
        verbArguments: VerbArguments,
        regularTransformations: List<RegularTransformation>,
        portugueseLocale: PortugueseLocale
    ): List<String>? {
        //trying updatedExtendedFormGroup
        val createdByFormGroup = updatedExtendedFormGroup?.getForm(verbArguments, portugueseLocale)
        if (createdByFormGroup != null) {
            return createdByFormGroup
        }
        val irregularSuffix = suffixGroup?.getSuffix(verbArguments)
        val irregularBase = baseGroup?.getBase(verbArguments) ?: base
        if (irregularSuffix == null) {
            if (irregularBase != null && regularTransformations.isNotEmpty()) {
                return regularTransformations
                    .map{it.suffix}
                    .distinct()
                    .map{suffix ->  irregularBase + suffix }
            }
        } else {
            if (irregularBase != null) {
                return listOf(irregularBase + irregularSuffix)
            } else if (regularTransformations.isNotEmpty()) {
                return regularTransformations
                    .map{it.base}
                    .distinct()
                    .map{base ->  base + irregularSuffix }
            }
        }
        //there is no irregular form
        return null
    }
}

