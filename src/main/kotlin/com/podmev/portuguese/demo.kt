package com.podmev.portuguese

import com.podmev.portuguese.engine.dataset.verb.getAllConjugationGroups

fun main() {
//    getAllVerbs().forEach {
//        println(it)
//    }

//    getAllInputVerbMetas().take(3).forEach{
//        println(it)
//    }

//    println(findInputVerbMeta("estar"))

    getAllConjugationGroups().forEach {
        println(it)
    }
}