package com.podmev.portuguese

import com.podmev.portuguese.engine.dataset.verb.findInputVerbMeta
import com.podmev.portuguese.engine.dataset.verb.getAllInputVerbMetas

fun main() {
//    getAllVerbs().forEach {
//        println(it)
//    }

//    getAllInputVerbMetas().take(3).forEach{
//        println(it)
//    }

    println(findInputVerbMeta("estar"))
}