package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender


//TODO add tests for parseTenseByShortName

/*gender in of tenses is from conjugation dataset
*
* */
fun parseGenderByTenseShortName(tenseName: String): GrammaticalGender =
    when (tenseName) {
        "indicative/present" -> GrammaticalGender.UNDEFINED
        "indicative/imperfect" -> GrammaticalGender.UNDEFINED
        "indicative/preterite" -> GrammaticalGender.UNDEFINED
        "indicative/pluperfect" -> GrammaticalGender.UNDEFINED
        "indicative/future" -> GrammaticalGender.UNDEFINED

        "subjunctive/present" -> GrammaticalGender.UNDEFINED
        "subjunctive/future" -> GrammaticalGender.UNDEFINED
        "subjunctive/imperfect" -> GrammaticalGender.UNDEFINED

        "conditional" -> GrammaticalGender.UNDEFINED

        "imperative/negative" -> GrammaticalGender.UNDEFINED
        "imperative/affirmative" -> GrammaticalGender.UNDEFINED

        "infinitive/impersonal" -> GrammaticalGender.UNDEFINED
        "infinitive/personal" -> GrammaticalGender.UNDEFINED

        "pastparticipleshort/masculine" -> GrammaticalGender.MASCULINE
        "pastparticipleshort/feminine" -> GrammaticalGender.FEMININE

        "pastparticiplelong/masculine" -> GrammaticalGender.MASCULINE
        "pastparticiplelong/feminine" -> GrammaticalGender.FEMININE
        "pastparticiple/masculine" -> GrammaticalGender.MASCULINE
        "pastparticiple/feminine" -> GrammaticalGender.FEMININE

        "gerund" -> GrammaticalGender.UNDEFINED
        else -> GrammaticalGender.UNDEFINED
    }
