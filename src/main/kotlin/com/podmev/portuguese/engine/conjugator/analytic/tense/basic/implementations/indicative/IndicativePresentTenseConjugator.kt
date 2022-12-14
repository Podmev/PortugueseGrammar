package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.I_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.diacriticLetters.acute.O_Acute_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.O_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.U_Letter
import com.podmev.portuguese.data.grammar.term.verb.*
import com.podmev.portuguese.engine.conjugator.analytic.DefectiveVerbs
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.IrregularVerbs
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryE_LetterForI_LetterOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryGU_FragmentForG_FragmentOrNull
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper.replaceIfNecessaryG_LetterForJ_LetterOrNull
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.word.Wordifier

/*
*
[1521] VerbFormInfo(infinitive=agredir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[1523] VerbFormInfo(infinitive=agredir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[1524] VerbFormInfo(infinitive=agredir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[1543] VerbFormInfo(infinitive=aguar, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[1545] VerbFormInfo(infinitive=aguar, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[1547] VerbFormInfo(infinitive=aguar, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[1548] VerbFormInfo(infinitive=aguar, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[2013] VerbFormInfo(infinitive=aluir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[2014] VerbFormInfo(infinitive=aluir, tense=IndicativePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[2015] VerbFormInfo(infinitive=aluir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[6157] VerbFormInfo(infinitive=cobrir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[7107] VerbFormInfo(infinitive=consumir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[7109] VerbFormInfo(infinitive=consumir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[7110] VerbFormInfo(infinitive=consumir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[7303] VerbFormInfo(infinitive=convelir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[8959] VerbFormInfo(infinitive=descobrir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10315] VerbFormInfo(infinitive=digerir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10317] VerbFormInfo(infinitive=digerir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10319] VerbFormInfo(infinitive=digerir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10320] VerbFormInfo(infinitive=digerir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[10423] VerbFormInfo(infinitive=discernir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[11329] VerbFormInfo(infinitive=empedernir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[11707] VerbFormInfo(infinitive=encobrir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[12103] VerbFormInfo(infinitive=engolir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[12613] VerbFormInfo(infinitive=enxaguar, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[12615] VerbFormInfo(infinitive=enxaguar, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[12617] VerbFormInfo(infinitive=enxaguar, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[12618] VerbFormInfo(infinitive=enxaguar, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13891] VerbFormInfo(infinitive=esvair, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13892] VerbFormInfo(infinitive=esvair, tense=IndicativePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13893] VerbFormInfo(infinitive=esvair, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13894] VerbFormInfo(infinitive=esvair, tense=IndicativePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13895] VerbFormInfo(infinitive=esvair, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13915] VerbFormInfo(infinitive=europeizar, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13917] VerbFormInfo(infinitive=europeizar, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13919] VerbFormInfo(infinitive=europeizar, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[13920] VerbFormInfo(infinitive=europeizar, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[18005] VerbFormInfo(infinitive=malquerer, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[18637] VerbFormInfo(infinitive=mobiliar, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[18639] VerbFormInfo(infinitive=mobiliar, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[18641] VerbFormInfo(infinitive=mobiliar, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[19789] VerbFormInfo(infinitive=parir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[19791] VerbFormInfo(infinitive=parir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[19793] VerbFormInfo(infinitive=parir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[19794] VerbFormInfo(infinitive=parir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20575] VerbFormInfo(infinitive=polir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20577] VerbFormInfo(infinitive=polir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20579] VerbFormInfo(infinitive=polir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[20580] VerbFormInfo(infinitive=polir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21129] VerbFormInfo(infinitive=progredir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21131] VerbFormInfo(infinitive=progredir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21132] VerbFormInfo(infinitive=progredir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21260] VerbFormInfo(infinitive=prostituir, tense=IndicativePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21261] VerbFormInfo(infinitive=prostituir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21262] VerbFormInfo(infinitive=prostituir, tense=IndicativePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[21263] VerbFormInfo(infinitive=prostituir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[22009] VerbFormInfo(infinitive=recobrir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[22207] VerbFormInfo(infinitive=redescobrir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23029] VerbFormInfo(infinitive=resfolegar, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23031] VerbFormInfo(infinitive=resfolegar, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23033] VerbFormInfo(infinitive=resfolegar, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23347] VerbFormInfo(infinitive=reunir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23349] VerbFormInfo(infinitive=reunir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23351] VerbFormInfo(infinitive=reunir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23352] VerbFormInfo(infinitive=reunir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23893] VerbFormInfo(infinitive=saudar, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23895] VerbFormInfo(infinitive=saudar, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23897] VerbFormInfo(infinitive=saudar, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[23898] VerbFormInfo(infinitive=saudar, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[24813] VerbFormInfo(infinitive=sumir, tense=IndicativePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[24815] VerbFormInfo(infinitive=sumir, tense=IndicativePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[24816] VerbFormInfo(infinitive=sumir, tense=IndicativePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
[25489] VerbFormInfo(infinitive=tossir, tense=IndicativePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE, settings=ConjugateSettings(ignoreDefective=false, portugueseLocale=BRAZIL))
* * * */
object IndicativePresentTenseConjugator : IndicativeMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("o", "as", "a", "amos", "ais", "am")
    override val erSuffix = SuffixGroup("o", "es", "e", "emos", "eis", "em")
    override val irSuffix = SuffixGroup("o", "es", "e", "imos", "is", "em")

    override val irregularForms: Map<String, IrregularForm> = mapOf(
        Pair(IrregularVerbs.or.POR, IrregularForm(FormGroup("ponho", "pões", "põe", "pomos", "pondes", "põem"))),

        Pair(IrregularVerbs.ar.ESTAR, IrregularForm(FormGroup("estou", "estás", "está", null, null, "estão"))),
        Pair(IrregularVerbs.ar.DAR, IrregularForm(FormGroup("dou", "dás", "dá", null, null, "dão"))),

        Pair(IrregularVerbs.er.SER, IrregularForm(FormGroup("sou", "és", "é", "somos", "sois", "são"))),
        Pair(IrregularVerbs.er.TER, IrregularForm(FormGroup("tenho", "tens", "tem", "temos", "tendes", "têm"))),
        Pair(IrregularVerbs.er.HAVER, IrregularForm(FormGroup("hei", "hás", "há", null, null, "hão"))),
        Pair(IrregularVerbs.er.FAZER, IrregularForm(FormGroup("faço", null, "faz", null, null, null))),
        Pair(IrregularVerbs.er.DIZER, IrregularForm(FormGroup("digo", null, "diz", null, null, null))),
        Pair(IrregularVerbs.er.PODER, IrregularForm(FormGroup("posso", null, null, null, null, null))),
        Pair(IrregularVerbs.er.VER, IrregularForm(FormGroup("vejo", "vês", "vê", null, "vedes", "veem"))),
        Pair(IrregularVerbs.er.SABER, IrregularForm(FormGroup("sei", null, null, null, null, null))),
        Pair(IrregularVerbs.er.QUERER, IrregularForm(FormGroup(null, null, "quer", null, null, null))),
        //TODO change to suffix
        Pair(IrregularVerbs.er.LER, IrregularForm(FormGroup("leio", "lês", "lê", null, "ledes", "leem"))),
        Pair(IrregularVerbs.er.TRAZER, IrregularForm(FormGroup("trago", null, "traz", null, null, null))),
        Pair(IrregularVerbs.er.PERDER, IrregularForm(FormGroup("perco", null, null, null, null, null))),
        Pair(IrregularVerbs.er.CABER, IrregularForm(FormGroup("caibo", null, null, null, null, null))),
        Pair(IrregularVerbs.er.PROVER, IrregularForm(null, SuffixGroup("ejo", "ês", "ê", null, "edes", "eem"))),
        Pair(IrregularVerbs.er.CRER, IrregularForm(null, SuffixGroup("eio", "ês", "ê", null, "edes", "eem"))),
        Pair(IrregularVerbs.er.REQUERER, IrregularForm(FormGroup("requeiro", null, "requer", null, null, null))),
        Pair(IrregularVerbs.er.VALER, IrregularForm(FormGroup("valho", null, null, null, null, null))),
        Pair(IrregularVerbs.er.ERGUER, IrregularForm(FormGroup("ergo", null, null, null, null, null))),

        Pair(IrregularVerbs.ir.VIR, IrregularForm(FormGroup("venho", "vens", "vem", null, "vindes", "vêm"))),
        Pair(IrregularVerbs.ir.OUVIR, IrregularForm(FormGroup("ouço", null, null, null, null, null))), //ouço ≈ oiço
        Pair(IrregularVerbs.ir.PEDIR, IrregularForm(FormGroup("peço", null, null, null, null, null))),
        Pair(IrregularVerbs.ir.IR, IrregularForm(FormGroup("vou", "vais", "vai", "vamos", "ides", "vão"))),
        Pair(IrregularVerbs.ir.DORMIR, IrregularForm(FormGroup("durmo", null, null, null, null, null))),
        //Think how to make
        Pair(IrregularVerbs.ir.SUBIR, IrregularForm(FormGroup(null, "sobes", "sobe", null, null, "sobem"))),
        //Think how to make
        Pair(IrregularVerbs.ir.FUGIR, IrregularForm(FormGroup(null, "foges", "foge", null, null, "fogem"))),
        Pair(IrregularVerbs.ir.RIR, IrregularForm(FormGroup("rio", "ris", "ri", null, "rides", "riem"))),
    )
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() =
            mapOf(
                Pair(
                    DefectiveGroup(false, false, false, true, true, false),
                    listOf(
                        DefectiveVerbs.ABOLIR,
                        DefectiveVerbs.COLORIR,
                        DefectiveVerbs.DEMOLIR,
                        DefectiveVerbs.DESCOLORIR,
                        DefectiveVerbs.FALIR,
                        DefectiveVerbs.FLORIR,
                        DefectiveVerbs.REMIR,
                    )
                ),
                Pair(
                    DefectiveGroup(false, true, true, true, true, true),
                    listOf(

                        DefectiveVerbs.BARRIR,
                        DefectiveVerbs.DELIR,
                        DefectiveVerbs.EXPLODIR,
                        DefectiveVerbs.GANIR,
                        DefectiveVerbs.LATIR,
                        DefectiveVerbs.RUIR,
                    )
                )
            )

    object UZIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UZIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.copy(singularThird = "") //finishes with -z
    }

    object AZER_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AZER
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.copy(singularThird = "") //finishes with -z
    }

    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.AIR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup("io", "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }

    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.UIR
        override val exceptions: List<String> = listOf("seguir", "extinguir", "distinguir", "retorquir")
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(regularSuffix.singularFirst, "is", "i", "ímos", "ís", regularSuffix.pluralThird)
    }

    object EAR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.EAR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup("io", "ias", "ia", regularSuffix.pluralFirst, regularSuffix.pluralSecond, "iam")
    }

    //we need to take three letters
    //works only for fixed list of verbs MARIO - first letters of verbs
    object IAR_Suffix_MARIO_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.IAR
        override val fixedVerbList = listOf(
            "mediar", "ansiar", "remediar", "incendiar", "odiar",
            "intermediar" // additional
        )

        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(
                "eio", "eias", "eia", "iamos", "iais", "eiam",
                droppingSuffixLength = 3
            )
    }

    //we need to take three letters
    object OER_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.OER
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            regularSuffix.extendChar('o').copy(singularSecond = "óis", singularThird = "ói")
    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
        UZIR_Suffix_Rule,
        AZER_Suffix_Rule,
        AIR_Suffix_Rule,
        UIR_Suffix_Rule,
        EAR_Suffix_Rule,
        IAR_Suffix_MARIO_Rule,
        OER_Suffix_Rule
    )

    object C_TO_C_Cedilla_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryC_LetterForC_Cedilla_LetterOrNull(verb)
    }

    object G_TO_J_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryG_LetterForJ_LetterOrNull(verb)
    }

    object EGU_TO_IG_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryEGU_FragmentForIG_FragmentOrNull(verb)
    }

    object GU_TO_G_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()

        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryGU_FragmentForG_FragmentOrNull(verb)
    }

    object E_TO_I_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isFirstSingular()
        override val exceptions: List<String>
            get() = listOf("manutenir", "impelir", "premir", "renhir")

        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            replaceIfNecessaryE_LetterForI_LetterOrNull(verb)
    }

    object Construir_Destruir_U_TO_O_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isSecondSingular() || verbArgs.isThird()
        override val fixedVerbList: List<String> = listOf("construir", "destruir")
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String =
            Wordifier.replaceLastFoundGenericLetter(
                word = verb,
                fromGenericLetter = U_Letter,
                toGenericLetter =
                if (verbArgs.isThirdPlural())
                    O_Letter
                else O_Acute_Letter //second-singular and third-singular
            )
    }

    object OIBIR_I_TO_I_Acute_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = !verbArgs.isFirstOrSecondPlural()
        override val wordEnding: String = "oibir"
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String =
            Wordifier.replaceLastFoundGenericLetterInPrefix(
                word = verb,
                prefix = VerbHelper.dropInfinitiveSuffixXR(verb),
                fromGenericLetter = I_Letter,
                toGenericLetter = I_Acute_Letter
            )
    }

//bad rule - didn't work
//    object U_TO_O_Rule : BaseChangingRule {
//        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = verbArgs.isSecondSingular() || verbArgs.isThird()
//        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
//            replaceIfNecessaryU_LetterForO_LetterOrNull(verb)
//    }

    override val baseChangingRules = listOf(
        C_TO_C_Cedilla_Rule,
        G_TO_J_Rule,
        EGU_TO_IG_Rule,
        E_TO_I_Rule,// - excluded for now
        Construir_Destruir_U_TO_O_Rule,
        GU_TO_G_Rule,
        OIBIR_I_TO_I_Acute_Rule
//        U_TO_O_Rule
    )

    override fun toString(): String {
        return "IndicativePresentTenseConjugator"
    }
}