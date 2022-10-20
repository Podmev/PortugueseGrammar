package com.podmev.portuguese.data.grammar.term.pronoun

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson

interface PersonalPronoun {
    val pronounGroup: PersonalPronounGroup
    val gender: GrammaticalGender?

    val string: String
}

object PronounEu : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST)
    override val gender: GrammaticalGender?
        get() = null
    override val string: String
        get() = "eu"
}

object PronounTu : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.SECOND)
    override val gender: GrammaticalGender?
        get() = null
    override val string: String
        get() = "tu"
}

object PronounVoce : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender?
        get() = null
    override val string: String
        get() = "você"
}

object PronounEle : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val string: String
        get() = "ele"
}

object PronounEla : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val string: String
        get() = "ela"
}

object PronounNos : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.SECOND)
    override val gender: GrammaticalGender?
        get() = null
    override val string: String
        get() = "nós"
}

object PronounSenhor : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val string: String
        get() = "o Senhor"
}

object PronounSenhora : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.SINGULAR, GrammaticalPerson.FIRST)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val string: String
        get() = "a Senhora"
}

object PronounVoces : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val string: String
        get() = "vocês"
}

object PronounEles : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val string: String
        get() = "eles"
}

object PronounElas : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val string: String
        get() = "elas"
}

object PronounSenhores : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.MASCULINE
    override val string: String
        get() = "os Senhores"
}

object PronounSenhoras : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.THIRD)
    override val gender: GrammaticalGender
        get() = GrammaticalGender.FEMININE
    override val string: String
        get() = "as Senhoras"
}

object PronounVos : PersonalPronoun{
    override val pronounGroup: PersonalPronounGroup
        get() = PersonalPronounGroup(GrammaticalNumber.PLURAL, GrammaticalPerson.SECOND)
    override val gender: GrammaticalGender?
        get() = null
    override val string: String
        get() = "vós"
}