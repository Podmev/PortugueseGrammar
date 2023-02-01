package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.imperative

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativePresentTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.subjunctive.SubjunctivePresentTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.isSecond
import com.podmev.portuguese.engine.conjugator.analytic.FiniteTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.indicative.IndicativePresentTenseConjugator
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive.SubjunctivePresentTenseConjugator

/*

tu, vos - take presentIndicative, but take last letter (s)
ele, nos, eles - just take subjunctive

https://ciberduvidas.iscte-iul.pt/consultorio/perguntas/faz-e-faze/32768

'Na conjugação do verbo fazer, a forma faz corresponde quer à terceira pessoa do singular do presente do indicativo
(como em «O João faz o jantar»), quer à segunda pessoa do singular do imperativo («João, faz o jantar»).
A forma verbal faze, de natureza culta, é, por sua vez, a segunda pessoa do singular do imperativo do verbo fazer,
frequente, por exemplo, em romances do século XIX e dos primeiros decénios do século XX:
«Ó minha querida Senhora do Patrocínio, faze que a Adelinha goste outra vez de mim!»
(Eça de Queirós, A Relíquia, in Corpus do Português, Mark Davies e Michael Ferreira).
Esta dualidade morfológica no modo imperativo está presente em verbos em que a consoante
fricativa z aparece no final do radical verbal, como: trazer, dizer, introduzir,
reduzir, jazer, aprazer, etc.. No entanto, «costumam perder o -e na 2.ª pessoa do singular do
imperativo afirmativo os verbos dizer, fazer, trazer e os terminados em -uzir: dize (ou diz) tu, faze (ou faz) tu,
traze (ou traz) tu, aduze (ou aduz) tu, traduze (ou traduz) tu» (Celso Cunha e Lindley Cintra,
Nova Gramática do Português Contemporâneo, p. 389, 2002).'


'A gramática de Celso Cunha diz que os verbos DIZER, FAZER E TRAZER, na 2.ª pessoa do singular, apresentam no imperativo afirmativo duas formas: dize ou diz, faze ou faz, traze ou traz.

Gostaria, então, de obter uma confirmação dos senhores e uma explicação de como isso ocorre, pois, pela regra geral, a 2ª pessoa do singular do imperativo afirmativo viria do presente do indicativo com a perda apenas do "s" e não perderia o "e" também. Por exemplo: corre, vive, vende, etc... Talvez eu tenha entendido mal.'

in Ciberdúvidas da Língua Portuguesa, https://ciberduvidas.iscte-iul.pt/consultorio/perguntas/dizdize-fazfaze-traztraze/3313# [consultado em 01-02-2023]

'A gramática de Celso Cunha diz que os verbos DIZER, FAZER E TRAZER, na 2.ª pessoa do singular, apresentam no imperativo
afirmativo duas formas: dize ou diz, faze ou faz, traze ou traz.

Gostaria, então, de obter uma confirmação dos senhores e uma explicação de como isso ocorre, pois, pela regra geral,
a 2ª pessoa do singular do imperativo afirmativo viria do presente do indicativo com a perda apenas do "s"
e não perderia o "e" também. Por exemplo: corre, vive, vende, etc... Talvez eu tenha entendido mal.


 */
object AffirmativeImperativeTenseConjugator : BasicTenseConjugator, FiniteTenseConjugator() {
    //doesn't matter what is suffix, because we use originConjugator
    val commonSuffix = emptySuffixGroup
    override val arSuffix = commonSuffix
    override val erSuffix = commonSuffix
    override val irSuffix = commonSuffix

    override val globalDefectiveGroup = DefectiveGroup(false, true, true, true, true, true)

    //TODO refactor more organized
    override val originConjugator: Conjugator = object : Conjugator {
        override fun conjugateVerb(
            verbInInfinitive: String,
            tense: GrammaticalTense,
            verbArgs: VerbArguments,
            settings: ConjugateSettings
        ): List<String> =

            when {
                verbArgs.isSecond() -> {
                    val presentForms = IndicativePresentTenseConjugator.conjugateVerb(
                        verbInInfinitive,
                        IndicativePresentTense,
                        verbArgs,
                        settings
                    )
                    //dropping last s
                    presentForms.map { it.dropLast(1) }
                }

                else -> SubjunctivePresentTenseConjugator.conjugateVerb(
                    verbInInfinitive,
                    SubjunctivePresentTense,
                    verbArgs,
                    settings
                )
            }
    }

    override val baseChangingRules: List<BaseChangingRule> = emptyList()
    override val irregularForms: Map<String, IrregularForm> = emptyMap()
    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = emptyList()
    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = emptyMap()

    override fun toString(): String {
        return "AffirmativeImperativeTenseConjugator"
    }
}