package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.expression.ExpressionTense


/*General formula:
auxiliarVerb (in auxiliarVerbTense) + connectionWord + mainVerb (in some fixed form, usually infinitive)
* */
interface ExtraVerbExpressionTense : ExpressionTense{
    val auxiliarVerb: String
    val auxiliarVerbTense: GrammaticalTense
    /* connection word can be absent in some cases*/
    val connectionWord: String?
}