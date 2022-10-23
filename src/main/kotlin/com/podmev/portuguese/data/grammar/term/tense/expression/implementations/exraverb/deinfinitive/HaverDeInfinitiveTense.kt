package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.deinfinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class HaverDeInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbDeInfinitiveTense {
    override val auxiliarVerb: String = "haver"
    override fun toString(): String {
        return "HaverDeInfinitiveTense(auxiliarVerbTense=$auxiliarVerbTense)"
    }

}