package com.podmev.portuguese.data.grammar.term.tense.expression.implementations.exraverb.participle

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense

//TODO Think how to work with passive and active
/*result passive*/
data class EstarParticipleTense(override val auxiliarVerbTense: GrammaticalTense): AbstractVerbParticipleTense {
    override val auxiliarVerb: String = "estar"
}