package com.podmev.portuguese

import com.podmev.portuguese.engine.dataset.verb.findInputVerbMeta
import com.podmev.portuguese.reader.convertInputVerbMetaToVerbFormInfoMap

fun main() {
//    getAllVerbs().forEach {
//        println(it)
//    }

//    getAllInputVerbMetas().take(3).forEach{
//        println(it)
//    }

//    println(findInputVerbMeta("estar"))

//    getAllConjugationGroups().forEach {
//        println(it)
//    }

    val verbMeta = findInputVerbMeta("estar")!!
    convertInputVerbMetaToVerbFormInfoMap(verbMeta).forEach{println(it)}
}