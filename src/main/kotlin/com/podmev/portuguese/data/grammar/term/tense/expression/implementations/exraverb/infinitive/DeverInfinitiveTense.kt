package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class DeverInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "dever"
    override fun toString(): String {
        return "DeverInfinitiveTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }
}