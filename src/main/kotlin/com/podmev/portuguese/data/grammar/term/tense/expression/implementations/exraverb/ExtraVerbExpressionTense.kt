package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.expression.ExpressionTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalMood

//TODO add field - limits for tenses it can be used for
/*General formula:
auxiliarVerb (in auxiliarVerbTense) + connectionWord + mainVerb (in some fixed form, usually infinitive)
* */
interface ExtraVerbExpressionTense : ExpressionTense {
    val auxiliarVerb: String
    val auxiliarVerbTense: GrammaticalTense
    val mainVerbTense: GrammaticalTense

    /* connection word can be absent in some cases*/
    val connectionWord: String?
    override val mood: GrammaticalMood
        get() = auxiliarVerbTense.mood
    override val canHavePerson: Boolean
        get() = auxiliarVerbTense.canHavePerson
    override val canHaveNumber: Boolean
        get() = auxiliarVerbTense.canHaveNumber
    override val canHaveGender: Boolean
        get() = auxiliarVerbTense.canHaveGender
}