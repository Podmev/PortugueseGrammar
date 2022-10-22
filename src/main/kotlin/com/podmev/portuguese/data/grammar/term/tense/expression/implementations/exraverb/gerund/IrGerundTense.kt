package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.gerund

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

data class IrGerundTense(override val auxiliarVerbTense: GrammaticalTense) : AbstractVerbGerundTense {
    override val auxiliarVerb: String = "ir"
}