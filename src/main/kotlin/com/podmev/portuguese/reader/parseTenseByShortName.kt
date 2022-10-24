package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.ImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveImperfectTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePreteriteTense


//TODO add tests for parseTenseByShortName

/*name of tenses is from conjugation dataset
*
* made list with util function getAllConjugationGroups
subjunctive/preterite
indicative/present
conditional
infinitive/personal
pastparticiplelong/masculine
indicative/pluperfect
pastparticiple/masculine
imperative/negative
pastparticipleshort/masculine
imperative/affirmative
infinitive/impersonal
subjunctive/present
subjunctive/imperfect
indicative/future
indicative/imperfect
indicative/preterite
pastparticiplelong/feminine
pastparticipleshort/feminine
pastparticiple/feminine
gerund
* */
fun parseTenseByShortName(tenseName: String): List<GrammaticalTense> =
    when (tenseName) {
        "indicative/present" -> listOf(IndicativePresentTense)
        "indicative/imperfect" -> listOf(IndicativeImperfectTense)
        "indicative/preterite" -> listOf(IndicativePreteriteTense)
        "indicative/pluperfect" -> listOf(IndicativePluperfectTense)
        "indicative/future" -> listOf(IndicativeFutureTense)

        "subjunctive/present" -> listOf(SubjunctivePresentTense)
        "subjunctive/preterite" -> listOf(SubjunctivePreteriteTense)
        "subjunctive/imperfect" -> listOf(SubjunctiveImperfectTense)

        "conditional" -> listOf(ConditionalTense)

        // let's not use imperative/negative - it is mostly incorrect in dataset. Anyway negative is not used in model
        "imperative/negative" -> emptyList()
        "imperative/affirmative" -> listOf(ImperativeTense)

        "infinitive/impersonal" -> listOf(InfinitiveTense)
        "infinitive/personal" -> listOf(PersonalInfinitiveTense)

        "pastparticipleshort/masculine" -> listOf(PastParticipleForSerEstarTense)
        "pastparticipleshort/feminine" -> listOf(PastParticipleForSerEstarTense)

        "pastparticiplelong/masculine" -> listOf(PastParticipleTense)
        "pastparticiplelong/feminine" -> listOf(PastParticipleTense)
        "pastparticiple/masculine" -> listOf(PastParticipleTense, PastParticipleForSerEstarTense)
        "pastparticiple/feminine" -> listOf(PastParticipleTense, PastParticipleForSerEstarTense)

        "gerund" -> listOf(GerundTense)
        else -> emptyList()
    }
