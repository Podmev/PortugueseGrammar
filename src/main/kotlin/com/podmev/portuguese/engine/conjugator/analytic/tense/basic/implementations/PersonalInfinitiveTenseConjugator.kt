package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.PLURAL
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.SINGULAR
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson.*
import com.podmev.portuguese.data.grammar.term.orthography.Alphabet
import com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks.AcuteDiacriticMark
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.utils.word.Wordifier
import com.podmev.portuguese.engine.utils.word.VerbEnds

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
        verbArgs: VerbArguments
    ): List<String> {
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
        if (infinitive.endsWith(VerbEnds.UIR) && endingStartsWithVowel(ending)) {
            if (infinitive.endsWith(VerbEnds.GUIR) || infinitive.endsWith(VerbEnds.QUIR)) {
                //in this case rule doesn't work
                return infinitive
            }
            //change last 'i' for 'í': with acute accent (acento agudo)
            return Wordifier.addDiacriticsToLastFoundLetter(infinitive, I_Letter, AcuteDiacriticMark)
        }
        if (infinitive.endsWith(VerbEnds.AIR) && endingStartsWithVowel(ending)) {
            //change last 'i' for 'í': with acute accent (acento agudo)
            return Wordifier.addDiacriticsToLastFoundLetter(infinitive, I_Letter, AcuteDiacriticMark)
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