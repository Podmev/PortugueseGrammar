package com.podmev.portuguese.data.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson

interface PersonDeconjugator {
    fun getPersonByVerbForm(string: String): List<GrammaticalPerson>
}