package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.participle

import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbParticipleTense : ExtraVerbExpressionTense {
    override val connectionWord: String?
        get() = null
}