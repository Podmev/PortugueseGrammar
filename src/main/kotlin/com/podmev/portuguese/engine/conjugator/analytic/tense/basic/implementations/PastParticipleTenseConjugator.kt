package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations

import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.*
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber.UNDEFINED
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.VerbHelper
import com.podmev.portuguese.engine.conjugator.analytic.tense.basic.BasicTenseConjugator
import com.podmev.portuguese.engine.utils.verb.IrregularSubVerber
import com.podmev.portuguese.engine.utils.verb.SuffixTreeIrregularSubVerber
import com.podmev.portuguese.engine.utils.verb.VerbEnds
import com.podmev.portuguese.engine.utils.verb.searchRules.DiacriticsRule
import com.podmev.portuguese.engine.utils.verb.searchRules.LetterInFrontRule
import com.podmev.portuguese.engine.utils.verb.searchRules.PreparingRule
import com.podmev.portuguese.engine.utils.word.Wordifier

/*[root]
AnalyticConjugatorCheckByDataSetSeparateTenseTest
pastParticipleTest(VerbFormInfo)
[55] VerbFormInfo(infinitive=abrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[194] VerbFormInfo(infinitive=advir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[203] VerbFormInfo(infinitive=afazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[336] VerbFormInfo(infinitive=aluir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[437] VerbFormInfo(infinitive=antepor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[497] VerbFormInfo(infinitive=apor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[725] VerbFormInfo(infinitive=avir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[786] VerbFormInfo(infinitive=bendizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1001] VerbFormInfo(infinitive=circunscrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1027] VerbFormInfo(infinitive=cobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1098] VerbFormInfo(infinitive=compor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1132] VerbFormInfo(infinitive=condizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1203] VerbFormInfo(infinitive=contradizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1204] VerbFormInfo(infinitive=contrafazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1208] VerbFormInfo(infinitive=contrapor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1224] VerbFormInfo(infinitive=convir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1244] VerbFormInfo(infinitive=corroer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1339] VerbFormInfo(infinitive=decompor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1340] VerbFormInfo(infinitive=decompôr, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1402] VerbFormInfo(infinitive=depor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1494] VerbFormInfo(infinitive=descobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1501] VerbFormInfo(infinitive=descompor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1520] VerbFormInfo(infinitive=descrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1530] VerbFormInfo(infinitive=desdizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1568] VerbFormInfo(infinitive=desfazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1705] VerbFormInfo(infinitive=devir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1750] VerbFormInfo(infinitive=dispor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1775] VerbFormInfo(infinitive=dizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1780] VerbFormInfo(infinitive=doer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1869] VerbFormInfo(infinitive=emergir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[1952] VerbFormInfo(infinitive=encobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2172] VerbFormInfo(infinitive=escrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2316] VerbFormInfo(infinitive=esvair, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2320] VerbFormInfo(infinitive=europeizar, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2377] VerbFormInfo(infinitive=expor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2434] VerbFormInfo(infinitive=fazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2717] VerbFormInfo(infinitive=impor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2793] VerbFormInfo(infinitive=inscrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2827] VerbFormInfo(infinitive=interpor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2833] VerbFormInfo(infinitive=intervir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2891] VerbFormInfo(infinitive=justapor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2953] VerbFormInfo(infinitive=liquefazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2997] VerbFormInfo(infinitive=maldizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3113] VerbFormInfo(infinitive=moer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3229] VerbFormInfo(infinitive=opor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3230] VerbFormInfo(infinitive=oppôr, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3353] VerbFormInfo(infinitive=perfazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3437] VerbFormInfo(infinitive=pôr, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3441] VerbFormInfo(infinitive=pospor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3464] VerbFormInfo(infinitive=predizer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3477] VerbFormInfo(infinitive=prender, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3483] VerbFormInfo(infinitive=prescrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3491] VerbFormInfo(infinitive=pressupor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3499] VerbFormInfo(infinitive=prever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3533] VerbFormInfo(infinitive=propor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3537] VerbFormInfo(infinitive=proscrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3543] VerbFormInfo(infinitive=prostituir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3554] VerbFormInfo(infinitive=provir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3573] VerbFormInfo(infinitive=putrefazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3611] VerbFormInfo(infinitive=rarefazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3668] VerbFormInfo(infinitive=recobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3701] VerbFormInfo(infinitive=redescobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3702] VerbFormInfo(infinitive=redescrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3715] VerbFormInfo(infinitive=reescrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3717] VerbFormInfo(infinitive=refazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3784] VerbFormInfo(infinitive=remoer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3894] VerbFormInfo(infinitive=rever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3905] VerbFormInfo(infinitive=revolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3922] VerbFormInfo(infinitive=roer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3980] VerbFormInfo(infinitive=satisfazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4048] VerbFormInfo(infinitive=sobrepor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4056] VerbFormInfo(infinitive=sobrevir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4066] VerbFormInfo(infinitive=soer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4113] VerbFormInfo(infinitive=subscrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4145] VerbFormInfo(infinitive=supor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4270] VerbFormInfo(infinitive=transcrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4283] VerbFormInfo(infinitive=transpor, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4335] VerbFormInfo(infinitive=tumefazer, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4406] VerbFormInfo(infinitive=ver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4440] VerbFormInfo(infinitive=vir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)

abrir=[]
afazer=[contrafazer]
aluir=[]
antepor=[]
apor=[contrapor, justapor]
cobrir=[descobrir, encobrir, recobrir, redescobrir]
compor=[decompor, descompor]
depor=[]
descobrir=[redescobrir]
descrever=[redescrever]
dispor=[]
dizer=[bendizer, condizer, contradizer, desdizer, maldizer, predizer]
doer=[]
escrever=[descrever, prescrever, redescrever, reescrever]
esvair=[]
expor=[]
fazer=[afazer, contrafazer, desfazer, liquefazer, perfazer, putrefazer, rarefazer, refazer, satisfazer, tumefazer]
impor=[]
interpor=[]
moer=[remoer]
opor=[propor]
pôr=[decompôr, oppôr]
pospor=[]
prender=[]
prostituir=[]
refazer=[putrefazer, rarefazer]
rever=[circunscrever, descrever, escrever, inscrever, prescrever, prever, proscrever, redescrever, reescrever, subscrever, transcrever]
roer=[corroer]
sobrepor=[]
soer=[]
supor=[pressupor]
transpor=[]
ver=[circunscrever, descrever, escrever, inscrever, prescrever, prever, proscrever, redescrever, reescrever, rever, revolver, subscrever, transcrever]
vir=[advir, avir, convir, devir, intervir, provir, sobrevir]

[237] VerbFormInfo(infinitive=absolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[241] VerbFormInfo(infinitive=absorver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[745] VerbFormInfo(infinitive=adsorver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[748] VerbFormInfo(infinitive=adsorver, tense=PastParticipleTense, person=UNDEFINED, number=PLURAL, gender=FEMININE, voice=ACTIVE)
[2061] VerbFormInfo(infinitive=aprender, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[2741] VerbFormInfo(infinitive=atrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3929] VerbFormInfo(infinitive=chouver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[3933] VerbFormInfo(infinitive=chover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4105] VerbFormInfo(infinitive=cobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4325] VerbFormInfo(infinitive=comover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[4413] VerbFormInfo(infinitive=comprender, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[5833] VerbFormInfo(infinitive=desaprender, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[5973] VerbFormInfo(infinitive=descobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[6229] VerbFormInfo(infinitive=desenvolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[6617] VerbFormInfo(infinitive=desprender, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[6633] VerbFormInfo(infinitive=desprover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[6813] VerbFormInfo(infinitive=dever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[6825] VerbFormInfo(infinitive=devolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[7025] VerbFormInfo(infinitive=dissolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[7805] VerbFormInfo(infinitive=encobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[8329] VerbFormInfo(infinitive=entrever, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[8401] VerbFormInfo(infinitive=envolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[9264] VerbFormInfo(infinitive=esvair, tense=PastParticipleTense, person=UNDEFINED, number=PLURAL, gender=FEMININE, voice=ACTIVE)
[9321] VerbFormInfo(infinitive=evolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[9789] VerbFormInfo(infinitive=ferver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[10625] VerbFormInfo(infinitive=haver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[12549] VerbFormInfo(infinitive=mover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[13033] VerbFormInfo(infinitive=ouvir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[14109] VerbFormInfo(infinitive=promover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[14205] VerbFormInfo(infinitive=prover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[14669] VerbFormInfo(infinitive=recobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[14801] VerbFormInfo(infinitive=redescobrir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[15141] VerbFormInfo(infinitive=remover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[15381] VerbFormInfo(infinitive=resolver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[16069] VerbFormInfo(infinitive=servir, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[16225] VerbFormInfo(infinitive=sobreviver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[16369] VerbFormInfo(infinitive=sorver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[16761] VerbFormInfo(infinitive=tchover, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[17805] VerbFormInfo(infinitive=viver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)
[17837] VerbFormInfo(infinitive=volver, tense=PastParticipleTense, person=UNDEFINED, number=SINGULAR, gender=MASCULINE, voice=ACTIVE)


problems:
 - escrever: need to use base form screver
 - abrir: need to use base form brir
 - pôr: should ignore diacritics
 - escrever vs ver : we should choose longer verb
* */
object PastParticipleTenseConjugator : BasicTenseConjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        if (isRegular(verbInInfinitive)) {
            return regularConjugate(verbInInfinitive, verbArgs)
        }
        return irregularConjugate(verbInInfinitive, verbArgs)
    }

    private fun isRegular(verbInInfinitive: String): Boolean {
        return !irregularSubVerber.isIrregularVerb(verbInInfinitive)
//        return !fullIrregularFormMap.containsKey(verbInInfinitive)
    }

    private fun regularConjugate(verbInInfinitive: String, verbArgs: VerbArguments): List<String> {
        val preparedInfinitive = prepareInfinitive(verbInInfinitive)
        val preparedBase = VerbHelper.dropInfinitiveSuffixR(preparedInfinitive)
        val regularSuffix = getRegularSuffix(verbArgs.gender, verbArgs.number)
        val result = regularChanging(preparedBase, regularSuffix)
        return listOf(result)
    }

    private fun irregularConjugate(verbInInfinitive: String, verbArgs: VerbArguments): List<String> {
        val masculineSingularForm = irregularSubVerber.getIrregularForm(verbInInfinitive)!!
        val reducedForm = VerbHelper.dropSuffixO(masculineSingularForm)
        val formInGenderAndNumber = reducedForm + getMutableSuffixPart(verbArgs.gender, verbArgs.number)
        return listOf(formInGenderAndNumber)
    }

    private const val regularImmutableSuffixPart = "d"

    private fun getRegularSuffix(gender: GrammaticalGender, number: GrammaticalNumber): String =
        regularImmutableSuffixPart + getMutableSuffixPart(gender, number)

    //TODO can be defined in common code
    private fun getMutableSuffixPart(gender: GrammaticalGender, number: GrammaticalNumber): String =
        when (number) {
            SINGULAR, UNDEFINED -> when (gender) {
                MASCULINE, GrammaticalGender.UNDEFINED -> "o"
                FEMININE -> "a"
            }

            PLURAL -> when (gender) {
                MASCULINE, GrammaticalGender.UNDEFINED -> "os"
                FEMININE -> "as"
            }
        }

    private fun regularChanging(preparedBase: String, suffix: String): String = preparedBase + suffix

    private fun prepareInfinitive(infinitive: String): String {
        if (infinitive.endsWith(VerbEnds.O_CIRCUMFLEX_R)) {
            return Wordifier.deleteLastDiacritics(infinitive)
        }
        if (infinitive.endsWith(VerbEnds.ER)) {
            return Wordifier.replaceLastFoundGenericLetter(infinitive, E_Letter, I_Letter)
        }
        if (infinitive.endsWith(VerbEnds.IR)) {
            val changedForm = VerbHelper.replaceIfNecessaryLastI_LetterForI_Acute_LetterOrNull(infinitive)
            if (changedForm != null) {
                return changedForm
            }
        }
        //the most of the cases we don't change anything
        return infinitive
    }

    //TODO from here complicated verbs formed from others
    /*only masculine, singular*/
    val fullIrregularFormMap: Map<String, String> = mapOf(
        Pair("abrir", "aberto"),
        Pair("advir", "advindo"),
        Pair("afazer", "afeito"),
        Pair("aluir", "aluido"),
        Pair("antepor", "anteposto"),
        Pair("apor", "aposto"),
        Pair("avir", "avindo"),
        Pair("bendizer", "bendito"),
        Pair("circunscrever", "circunscrito"),
        Pair("cobrir", "coberto"),
        Pair("compor", "composto"),
        Pair("condizer", "condito"),
        Pair("contradizer", "contradito"),
        Pair("contrafazer", "contrafeito"),
        Pair("contrapor", "contraposto"),
        Pair("convir", "convindo"),
        Pair("corroer", "corroído"),
        Pair("decompor", "decomposto"),
        Pair("decompôr", "decomposto"),
        Pair("depor", "deposto"),
        Pair("descobrir", "descoberto"),
        Pair("descompor", "descomposto"),
        Pair("descrever", "descrito"),
        Pair("desdizer", "desdito"),
        Pair("desfazer", "desfeito"),
        Pair("devir", "devindo"),
        Pair("dispor", "disposto"),
        Pair("dizer", "dito"),
        Pair("doer", "doído"),
        Pair("encobrir", "encoberto"),
        Pair("escrever", "escrito"),
        Pair("esvair", "esvaido"),
        Pair("expor", "exposto"),
        Pair("fazer", "feito"),
        Pair("impor", "imposto"),
        Pair("inscrever", "inscrito"),
        Pair("interpor", "interposto"),
        Pair("intervir", "intervindo"),
        Pair("justapor", "justaposto"),
        Pair("liquefazer", "liquefeito"),
        Pair("maldizer", "maldito"),
        Pair("moer", "moído"),
        Pair("opor", "oposto"),
        Pair("oppôr", "opposto"),
        Pair("perfazer", "perfeito"),
        Pair("pôr", "posto"),
        Pair("pospor", "posposto"),
        Pair("predizer", "predito"),
        Pair("prender", "preso"),
        Pair("prescrever", "prescrito"),
        Pair("pressupor", "pressuposto"),
        Pair("prever", "previsto"),
        Pair("propor", "proposto"),
        Pair("proscrever", "proscrito"),
        Pair("prostituir", "prostituido"),
        Pair("provir", "provindo"),
        Pair("putrefazer", "putrefeito"),
        Pair("rarefazer", "rarefeito"),
        Pair("recobrir", "recoberto"),
        Pair("redescobrir", "redescoberto"),
        Pair("redescrever", "redescrito"),
        Pair("reescrever", "reescrito"),
        Pair("refazer", "refeito"),
        Pair("remoer", "remoído"),
        Pair("rever", "revisto"),
        Pair("revolver", "revolto"),
        Pair("roer", "roído"),
        Pair("satisfazer", "satisfeito"),
        Pair("sobrepor", "sobreposto"),
        Pair("sobrevir", "sobrevindo"),
        Pair("soer", "soído"),
        Pair("subscrever", "subscrito"),
        Pair("supor", "suposto"),
        Pair("transcrever", "transcrito"),
        Pair("transpor", "transposto"),
        Pair("tumefazer", "tumefeito"),
        Pair("ver", "visto"),
        Pair("vir", "vindo")
    )

    val simpleIrregularFormMap: Map<String, String> = mapOf(
        Pair("abrir", "aberto"),
        Pair("dizer", "dito"),
        Pair("doer", "doído"),
        Pair("escrever", "escrito"),
        Pair("fazer", "feito"),
        Pair("moer", "moído"),
        Pair("pôr", "posto"),
        Pair("prender", "preso"),
        Pair("revolver", "revolto"),
        Pair("roer", "roído"),
        Pair("soer", "soído"),
        Pair("ver", "visto"),
        Pair("vir", "vindo")
    )

    private val preparingRules: List<PreparingRule> = listOf(
        LetterInFrontRule(I_Letter),
        LetterInFrontRule(E_Letter),
        DiacriticsRule
    )

    val irregularSubVerber: IrregularSubVerber = SuffixTreeIrregularSubVerber(simpleIrregularFormMap, preparingRules)

    override fun toString(): String {
        return "PastParticipleTenseConjugator"
    }
}