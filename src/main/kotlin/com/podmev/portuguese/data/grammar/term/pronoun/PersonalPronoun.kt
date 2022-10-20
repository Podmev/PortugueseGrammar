package com.podmev.portuguese.data.grammar.term.pronoun

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender

interface PersonalPronoun {
    val pronounGroup: PersonalPronounGroup
    val gender: GrammaticalGender?
}
