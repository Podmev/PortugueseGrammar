package com.podmev.portuguese.engine.conjugator.analytic

import com.podmev.portuguese.utils.lang.mergeListMaps
import com.podmev.portuguese.utils.lang.revertListMap

object VerbLists {
    val onlyThirdSingularFormVerbs = listOf(
        "gear",
        "nevar",
        "doer",
        "prazer",
        "aprazer"
    )
    //TODO add necessary verbs
    val irregularVerbDerivativeMap: Map<String, List<String>> = mapOf(
        Pair("dizer", listOf("bendizer", "condizer", "contradizer", "desdizer", "maldizer", "predizer")),
        Pair(
            "escrever", listOf(
                "circunscrever", "descrever", "escrever", "inscrever", "prescrever", "proscrever", "redescrever",
                "reescrever", "subscrever", "transcrever"
            )
        ),
        Pair(
            "fazer", listOf(
                "afazer", "contrafazer", "desfazer", "liquefazer", "perfazer", "putrefazer", "rarefazer",
                "refazer", "satisfazer", "tumefazer"
            )
        ),
        Pair("pedir", listOf("impedir", "desimpedir", "despedir", "espedir", "expedir")),
        Pair(
            "pôr", listOf(
                "apor", "antepor", "compor", "contrapor", "decompor", "decompôr", "descompor", "depor",
                "dispor", "expor", "impor", "interpor", "justapor", "opor", "oppôr", "pospor", "pressupor", "propor",
                "sobrepor", "supor", "transpor"
            )
        ),
//        Pair("querer", listOf("requerer", "bem-querer", "benquerer", "desquerer", "entrequerer", "malquerer")),
        Pair("vir", listOf("advir", "avir", "convir", "devir", "intervir", "provir", "sobrevir")),
        Pair("ver", listOf("prever", "rever")),
    )

    val irregularVerbSameRuleMap: Map<String, List<String>> = mapOf(
        Pair("pedir", listOf("medir")),
    )

    val irregularVerbOriginMap: Map<String, String> = revertListMap(
        mergeListMaps(irregularVerbDerivativeMap, irregularVerbSameRuleMap)
    )
}