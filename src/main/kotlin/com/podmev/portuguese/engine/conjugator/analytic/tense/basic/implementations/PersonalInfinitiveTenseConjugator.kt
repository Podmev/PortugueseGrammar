package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.engine.conjugator.ConjugateSettings
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.PLURAL
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.SINGULAR
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.orthography.Alphabet
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.VerbLists
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.engine.utils.verb.VerbEnds

/*Additional rules:
1 -    Combination: VerbFormInfo(infinitive=instituir, tense=PersonalInfinitiveTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE) ==>
expected: <[instituírem]> but was: <[instituirem]>
2 - Combination: VerbFormInfo(infinitive=pôr, tense=PersonalInfinitiveTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE) ==>
expected: <[porem]> but was: <[pôrem]>
3 - Combination: VerbFormInfo(infinitive=oppôr, tense=PersonalInfinitiveTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE) ==>
expected: <[oppormos]> but was: <[oppôrmos]>
4 - Combination: VerbFormInfo(infinitive=prazer, tense=PersonalInfinitiveTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE) ==> expected: <[-Normally defective:prazer]> but was: <[prazer]>

*/
object PersonalInfinitiveTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments,
        settings: ConjugateSettings
    ): List<String> {
        if(VerbHelper.forbiddenOnNotThirdSingularForm(verbInInfinitive, verbArgs)){
            return emptyList()
        }
        val ending = getAdditionalSuffix(verbArgs.person, verbArgs.number)
        if (ending.isEmpty()) {
            return listOf(verbInInfinitive)
        }
        //since now word will be bigger
        val newBase = changeBase(verbInInfinitive, ending)
        val form = "$newBase$ending"
        return listOf(form)
    }

    private fun endingStartsWithVowel(ending: String): Boolean = Alphabet.isVowelChar(ending.first())

    private fun changeBase(infinitive: String, ending: String): String {
        if(endingStartsWithVowel(ending)){
            val changedForm = VerbHelper.replaceIfNecessaryLastI_LetterForI_Acute_LetterOrNull(infinitive)
            if(changedForm!=null){
                return changedForm
            }
        }

        if (infinitive.endsWith(VerbEnds.O_CIRCUMFLEX_R)) {
            //change last 'ô' for 'o': with circumflex. verbs pôr, oppôr
            return Wordifier.deleteLastDiacritics(infinitive)
        }
        return infinitive
    }

    private fun getAdditionalSuffix(person: GrammaticalPerson, number: GrammaticalNumber): String =
        when (number) {
            GrammaticalNumber.UNDEFINED -> ""
            SINGULAR ->
                when (person) {
                    FIRST -> ""
                    SECOND -> "es"
                    THIRD -> ""
                    UNDEFINED -> ""
                }

            PLURAL ->
                when (person) {
                    FIRST -> "mos"
                    SECOND -> "des"
                    THIRD -> "em"
                    UNDEFINED -> ""
                }
        }

    override fun toString(): String {
        return "PersonalInfinitiveTenseConjugator"
    }

//    fun addAcuteAccentToLastI_Letter(s: String):String{
//
//    }
//
//    fun replaceLastFoundGeneralLetter()
}