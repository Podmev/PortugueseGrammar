package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.infinitive

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.InfinitiveTense
import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbInfinitiveTense : ExtraVerbExpressionTense {
    override val connectionWord: String?
        get() = null

    override val mainVerbTense: GrammaticalTense
        get() = InfinitiveTense
}