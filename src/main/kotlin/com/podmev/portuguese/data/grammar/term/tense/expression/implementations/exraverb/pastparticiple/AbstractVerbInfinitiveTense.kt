package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.pastparticiple

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.PastParticipleForSerEstarTense
import com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.ExtraVerbExpressionTense

interface AbstractVerbPastParticipleTense : ExtraVerbExpressionTense {
    override val connectionWord: String?
        get() = null

    override val mainVerbTense: GrammaticalTense
        get() = PastParticipleForSerEstarTense
}