package com.podmev.portuguese.engine.conjugator.analytic

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

//        Pair("abrir", listOf("")),
//        Pair("cobrir", listOf("descobrir", "encobrir", "recobrir", "redescobrir")),
//        Pair("descobrir", listOf("redescobrir")),
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
        Pair(
            "pôr", listOf(
                "apor", "antepor", "compor", "contrapor", "decompor", "decompôr", "descompor", "depor",
                "dispor", "expor", "impor", "interpor", "justapor", "opor", "oppôr", "pospor", "pressupor", "propor",
                "sobrepor", "supor", "transpor"
            )
        ),
//        Pair("prender", listOf("")),
//        Pair("prostituir", listOf("")),
//        Pair("roer", listOf("corroer")),
//        Pair("soer", listOf("")),
        Pair("vir", listOf("advir", "avir", "convir", "devir", "intervir", "provir", "sobrevir")),
        Pair("ver", listOf("prever", "rever")),
    )

    val irregularVerbOriginMap: Map<String, String> = revertListMap(irregularVerbDerivativeMap)
}