package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class GenericVerbInfinitiveTense(
    override val auxiliarVerb: String,
    override val auxiliarVerbTense: GrammaticalTense
) : AbstractVerbInfinitiveTense
