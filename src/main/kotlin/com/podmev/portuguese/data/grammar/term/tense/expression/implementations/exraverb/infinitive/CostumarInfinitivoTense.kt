package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class CostumarInfinitivoTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "costumar"
    override fun toString(): String {
        return "CostumarInfinitivoTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }
}