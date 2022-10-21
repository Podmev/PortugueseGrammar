package com.podmev.portuguese.data.grammar.term.pronoun

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson

interface PersonalPronoun {
    val pronounGroup: PersonalPronounGroup
    val gender: GrammaticalGender

    val spelling: String
}

fun allPersonalPronouns(): List<PersonalPronoun> =
    listOf(
        PronounEu,
        PronounTu,
        PronounVoce,
        PronounEle,
        PronounEla,
        PronounNos,
        PronounSenhor,
        PronounSenhora,
        PronounVoces,
        PronounEles,
        PronounElas,
        PronounSenhores,
        PronounSenhoras,
        PronounVos
    )

fun personalPronounsByGroup(group: PersonalPronounGroup): List<PersonalPronoun> =
    allPersonalPronouns().filter { it.pronounGroup == group }

fun personalPronounsByGender(gender: GrammaticalGender): List<PersonalPronoun> =
    allPersonalPronouns().filter { it.gender == gender }

object PronounEu : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.UNDEFINED
    override val spelling: String
        get() = "eu"

    override fun toString(): String = spelling
}

object PronounTu : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.SECOND)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.UNDEFINED
    override val spelling: String
        get() = "tu"

    override fun toString(): String = spelling
}

object PronounVoce : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.UNDEFINED
    override val spelling: String
        get() = "você"

    override fun toString(): String = spelling
}

object PronounEle : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val spelling: String
        get() = "ele"

    override fun toString(): String = spelling
}

object PronounEla : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val spelling: String
        get() = "ela"

    override fun toString(): String = spelling
}

object PronounNos : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.FIRST)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.UNDEFINED
    override val spelling: String
        get() = "nós"

    override fun toString(): String = spelling
}

object PronounSenhor : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val spelling: String
        get() = "o Senhor"

    override fun toString(): String = spelling
}

object PronounSenhora : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val spelling: String
        get() = "a Senhora"

    override fun toString(): String = spelling
}

object PronounVoces : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.UNDEFINED
    override val spelling: String
        get() = "vocês"

    override fun toString(): String = spelling
}

object PronounEles : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val spelling: String
        get() = "eles"

    override fun toString(): String = spelling
}

object PronounElas : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val spelling: String
        get() = "elas"

    override fun toString(): String = spelling
}

object PronounSenhores : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val spelling: String
        get() = "os Senhores"

    override fun toString(): String = spelling
}

object PronounSenhoras : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val spelling: String
        get() = "as Senhoras"

    override fun toString(): String = spelling
}

object PronounVos : PersonalPronoun {
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.SECOND)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.UNDEFINED
    override val spelling: String
        get() = "vós"

    override fun toString(): String = spelling
}