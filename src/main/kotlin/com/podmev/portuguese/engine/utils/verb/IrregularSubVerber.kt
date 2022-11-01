package com.podmev.portuguese.engine.utils.verb

interface IrregularSubVerber {
    fun findNonEmptySuffix(verb: String): String?
    fun isIrregularVerb(verb: String): Boolean
    fun getIrregularForm(verb: String): String?
}