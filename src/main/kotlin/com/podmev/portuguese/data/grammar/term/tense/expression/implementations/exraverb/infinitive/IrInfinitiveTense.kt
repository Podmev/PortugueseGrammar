package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class IrInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "ir"
    override fun toString(): String {
        return "IrInfinitiveTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }
}