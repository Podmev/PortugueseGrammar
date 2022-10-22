package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.expression.ExpressionTense

interface ExtraVerbExpressionTense : ExpressionTense{
    val auxiliarVerb: String
    val auxiliarVerbTense: GrammaticalTense
}