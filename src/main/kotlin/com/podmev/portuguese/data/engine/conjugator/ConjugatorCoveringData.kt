package com.podmev.portuguese.data.engine.conjugator

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo

/*
* persons, numbers and genders you can take from tense
* */
data class ConjugatorCoveringData(
    val verbInfinitives: Sequence<String>,
    val tenses: Sequence<GrammaticalTense>,
    val voices: Sequence<GrammaticalVoice>,
    val settingsCombinations: Sequence<ConjugateSettings>
) {


    //example for comprehension
    fun pythagoreanTriples(n: Int) =
        (1..n).flatMap { x ->
            (x..n).flatMap { y ->
                (y..n).filter { z ->
                    x * x + y * y == z * z
                }.map { Triple(x, y, it) }
            }
        }

    @Suppress("UNUSED_PARAMETER")
    fun main(args: Array<String>) {
        println(pythagoreanTriples(20))
    }

    fun getAllVerbFormInfos(): Iterable<VerbFormInfo> =
        verbInfinitives.flatMap { verb ->
            tenses.flatMap { tense ->
                tense.possiblePronounGroups().flatMap { pronounGroup: PersonalPronounGroup ->
                    tense.possibleGenders().flatMap { gender ->
                        voices.flatMap { voice ->
                            settingsCombinations.map { settings ->
                                VerbFormInfo(
                                    verb,
                                    tense,
                                    pronounGroup.grammaticalPerson,
                                    pronounGroup.grammaticalNumber,
                                    gender,
                                    voice,
                                    settings
                                )
                            }
                        }
                    }
                }
            }
        }.asIterable()

    /*for tests*/
    fun getVerbFormSingularMasculineNoPersonInfos(): Iterable<VerbFormInfo> =
        verbInfinitives.flatMap { verb ->
            tenses.flatMap { tense ->
                voices.flatMap { voice ->
                    settingsCombinations.map { settings ->
                        VerbFormInfo(
                            verb,
                            tense,
                            GrammaticalPerson.UNDEFINED,
                            GrammaticalNumber.SINGULAR,
                            GrammaticalGender.MASCULINE,
                            voice,
                            settings
                        )
                    }
                }
            }
        }.asIterable()

}
