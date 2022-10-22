package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbInfinitiveTense : ExtraVerbExpressionTense {
    override val connectionWord: String?
        get() = null
}