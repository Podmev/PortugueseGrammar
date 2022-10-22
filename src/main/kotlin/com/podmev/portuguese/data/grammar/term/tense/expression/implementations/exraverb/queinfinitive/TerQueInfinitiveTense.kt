package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.queinfinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class TerQueInfinitiveTense(override val auxiliarVerbTense: GrammaticalTense): AbstractVerbQueInfinitiveTense {
    override val auxiliarVerb: String = "ter"
}