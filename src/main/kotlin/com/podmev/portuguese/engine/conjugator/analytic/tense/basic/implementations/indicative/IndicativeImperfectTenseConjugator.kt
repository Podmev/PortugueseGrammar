package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs
import com.podmev.portuguese.engine.utils.verb.VerbEnds
/*
[6985] VerbFormInfo(infinitive=conseguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[6987] VerbFormInfo(infinitive=conseguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[6989] VerbFormInfo(infinitive=conseguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[6990] VerbFormInfo(infinitive=conseguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[7083] VerbFormInfo(infinitive=construir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9049] VerbFormInfo(infinitive=desconseguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9051] VerbFormInfo(infinitive=desconseguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9053] VerbFormInfo(infinitive=desconseguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9054] VerbFormInfo(infinitive=desconseguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9979] VerbFormInfo(infinitive=desseguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9981] VerbFormInfo(infinitive=desseguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9983] VerbFormInfo(infinitive=desseguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[9984] VerbFormInfo(infinitive=desseguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10077] VerbFormInfo(infinitive=destruir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10561] VerbFormInfo(infinitive=distinguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10563] VerbFormInfo(infinitive=distinguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10565] VerbFormInfo(infinitive=distinguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10566] VerbFormInfo(infinitive=distinguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13891] VerbFormInfo(infinitive=esvair, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13893] VerbFormInfo(infinitive=esvair, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13895] VerbFormInfo(infinitive=esvair, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13896] VerbFormInfo(infinitive=esvair, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[14353] VerbFormInfo(infinitive=extinguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[14355] VerbFormInfo(infinitive=extinguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[14357] VerbFormInfo(infinitive=extinguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[14358] VerbFormInfo(infinitive=extinguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20221] VerbFormInfo(infinitive=perseguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20223] VerbFormInfo(infinitive=perseguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20225] VerbFormInfo(infinitive=perseguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20226] VerbFormInfo(infinitive=perseguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21253] VerbFormInfo(infinitive=prosseguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21255] VerbFormInfo(infinitive=prosseguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21257] VerbFormInfo(infinitive=prosseguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21258] VerbFormInfo(infinitive=prosseguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[22089] VerbFormInfo(infinitive=reconstruir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23299] VerbFormInfo(infinitive=retorquir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23301] VerbFormInfo(infinitive=retorquir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23303] VerbFormInfo(infinitive=retorquir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23304] VerbFormInfo(infinitive=retorquir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23977] VerbFormInfo(infinitive=seguir, tense=IndicativeImperfectTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23979] VerbFormInfo(infinitive=seguir, tense=IndicativeImperfectTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23981] VerbFormInfo(infinitive=seguir, tense=IndicativeImperfectTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23982] VerbFormInfo(infinitive=seguir, tense=IndicativeImperfectTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
* */
object IndicativeImperfectTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("ava", "avas", "ava", "ávamos", "áveis", "avam")
    override val erSuffix = SuffixGroup("ia", "ias", "ia", "íamos", "íeis", "iam")
    override val irSuffix = erSuffix //exactly the same

    val specialSuffix = SuffixGroup("ía", "ías", "ía", "íamos", "íeis", "íam")


    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(
            IrregularVerbs.or.POR,
            IrregularForm(FormGroup("punha", "punhas", "punha", "púnhamos", "púnheis", "punham"))
        ),
        Pair(IrregularVerbs.er.SER, IrregularForm(FormGroup("era", "eras", "era", "éramos", "éreis", "eram"))),
        Pair(
            IrregularVerbs.er.TER,
            IrregularForm(FormGroup("tinha", "tinhas", "tinha", "tínhamos", "tínheis", "tinham"))
        ),
        Pair(
            IrregularVerbs.ir.VIR,
            IrregularForm(FormGroup("vinha", "vinhas", "vinha", "vínhamos", "vínheis", "vinham"))
        ),
    )

    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) = specialSuffix
    }

    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) = specialSuffix

    }

    object OER_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.OER
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) = specialSuffix

    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
        AIR_Suffix_Rule,
        UIR_Suffix_Rule,
        OER_Suffix_Rule
    )
    override val baseChangingRules: List<BaseChangingRule>
        get() = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf()

    override fun toString(): String {
        return "IndicativeImperfectTenseConjugator"
    }
}