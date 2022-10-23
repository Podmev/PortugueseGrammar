package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

/*Exists form precisar de <noun>,  we don't use it here*/
data class PrecisarInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "precisar"
    override fun toString(): String {
        return "PrecisarInfinitiveTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }
}