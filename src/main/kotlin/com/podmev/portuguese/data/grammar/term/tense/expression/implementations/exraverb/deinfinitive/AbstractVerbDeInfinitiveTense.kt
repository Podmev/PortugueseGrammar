package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.deinfinitive

import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbDeInfinitiveTense : ExtraVerbExpressionTense {
    override val connectionWord: String
        get() = "de"
}