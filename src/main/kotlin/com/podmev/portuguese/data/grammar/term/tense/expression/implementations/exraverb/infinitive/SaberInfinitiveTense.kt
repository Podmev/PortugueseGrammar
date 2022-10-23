package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class SaberInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "saber"
    override fun toString(): String {
        return "SaberInfinitiveTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }
}