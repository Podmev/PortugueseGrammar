package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class ConhecerInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "conhecer"
    override fun toString(): String {
        return "ConhecerInfinitiveTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }
}