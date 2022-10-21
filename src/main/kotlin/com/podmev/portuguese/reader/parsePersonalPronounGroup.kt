package com.podmev.portuguese.reader

import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.pronoun.PersonalPronounGroup

/*Parsing PersonalPronounGroup from string with special view from files in resources about verbs (external source of data)
*  string can be 1 or two symbols
*  first symbol is 's' or 'p'. 's' means singular, 'p' means plural
*  if second symbol exists it is digit: 1, 2 or 3. It means first, second or third person
*
* If format is wrong, returns null
* */
fun parsePersonalPronounGroup(s: String): PersonalPronounGroup? {
    if (s.length !in 1..2) return null
    val firstSymbol = s[0]
    val secondSymbol = s.getOrNull(1)
    if (firstSymbol !in listOf('p', 's')) return null
    if (secondSymbol !in listOf('1', '2', '3', null)) return null

    val grammaticalNumber = if (firstSymbol == 'p') GrammaticalNumber.PLURAL else GrammaticalNumber.SINGULAR
    val grammaticalPerson = when (secondSymbol) {
        '1' -> GrammaticalPerson.FIRST
        '2' -> GrammaticalPerson.SECOND
        '3' -> GrammaticalPerson.THIRD
        else -> GrammaticalPerson.UNDEFINED
    }

    return PersonalPronounGroup(grammaticalNumber, grammaticalPerson)
}