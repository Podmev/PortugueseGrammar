package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.InfinitiveTense
import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.deinfinitive.AbstractVerbDeInfinitiveTense

data class InfinitiveInfinitiveTense(override val auxiliarVerb: String) : AbstractVerbDeInfinitiveTense {
    override val auxiliarVerbTense: GrammaticalTense = InfinitiveTense

}
