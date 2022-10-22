package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.pastparticiple

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

//TODO Think how to work with passive and active
/*result passive*/
data class EstarPastParticipleTense(override val auxiliarVerbTense: GrammaticalTense): AbstractVerbPastParticipleTense {
    override val auxiliarVerb: String = "estar"
}