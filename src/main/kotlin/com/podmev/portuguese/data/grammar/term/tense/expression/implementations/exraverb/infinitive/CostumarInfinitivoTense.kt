package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.deinfinitive.AbstractVerbDeInfinitiveTense

data class CostumarInfinitivoTense(override val auxiliarVerbTense: GrammaticalTense): AbstractVerbInfinitiveTense {
    override val auxiliarVerb: String = "costumar"
}