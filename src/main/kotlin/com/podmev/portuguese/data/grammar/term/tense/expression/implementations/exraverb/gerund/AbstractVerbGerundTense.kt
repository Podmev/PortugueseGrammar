package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.gerund

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.GerundTense
import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbGerundTense : ExtraVerbExpressionTense {
    override val connectionWord: String?
        get() = null

    override val mainVerbTense: GrammaticalTense
        get() = GerundTense
}