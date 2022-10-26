package com.podmev.portuguese.data.grammar.term.predicate

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbForm

/*Part of sentence with verb: main content verb or associated predicative expression of a clause*/
@Suppress("UNUSED_PARAMETER")
class VerbalPredicate(
    verbForms: List<VerbForm>, //TODO fix what can be in  list: it can be preposition and parts of pronoun
    tense: GrammaticalTense
) {
    //TODO add auxiliary part and main part
    //TODO think about negative form: it is predicate or verb form
    //TODO think what to do with verb frases like : falling in love
}