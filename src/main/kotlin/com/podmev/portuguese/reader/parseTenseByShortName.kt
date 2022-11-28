package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.AffirmativeImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.NegativeImperativeTense
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

        "imperative/negative" -> listOf(NegativeImperativeTense)
        "imperative/affirmative" -> listOf(AffirmativeImperativeTense)

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
