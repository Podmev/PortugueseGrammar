package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.condicional.ConditionalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative.ImperativeTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.*
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctiveImperfectTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePreteriteTense

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
fun parseTenseByShortName(tenseName: String): GrammaticalTense? =
    when (tenseName) {
        "indicative/present" -> IndicativePresentTense
        "indicative/imperfect" -> IndicativeImperfectTense
        "indicative/preterite" -> IndicativePreteriteTense
        "indicative/pluperfect" -> IndicativePluperfectTense
        "indicative/future" -> IndicativeFutureTense

        "subjunctive/present" -> SubjunctivePresentTense
        "subjunctive/preterite" -> SubjunctivePreteriteTense
        "subjunctive/imperfect" -> SubjunctiveImperfectTense

        "conditional" -> ConditionalTense

        // let's not use imperative/negative - it is mostly incorrect in dataset. Anyway negative is not used in model
        "imperative/negative" -> null
        "imperative/affirmative" -> ImperativeTense

        "infinitive/impersonal" -> InfinitiveTense
        "infinitive/personal" -> PersonalInfinitiveTense

        "pastparticipleshort/masculine" -> PastParticipleForSerEstarTense
        "pastparticipleshort/feminine" -> PastParticipleForSerEstarTense

        "pastparticiplelong/masculine" -> PastParticipleTense
        "pastparticiplelong/feminine" -> PastParticipleTense
        "pastparticiple/masculine" -> PastParticipleTense
        "pastparticiple/feminine" -> PastParticipleTense

        "gerund" -> GerundTense
        else -> null
    }
