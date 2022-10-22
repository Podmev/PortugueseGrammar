package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.queinfinitive

import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbQueInfinitiveTense : ExtraVerbExpressionTense {
    override val connectionWord: String
        get() = "que"
}