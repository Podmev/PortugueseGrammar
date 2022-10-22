package com.podmev.portuguese.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson

interface PersonDeconjugator {
    fun getPersonByVerbForm(string: String): List<GrammaticalPerson>
}