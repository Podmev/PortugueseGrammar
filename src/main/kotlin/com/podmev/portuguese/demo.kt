package com.podmev.portuguese

import com.podmev.portuguese.engine.dataset.verb.getAllVerbs

fun main(){
    getAllVerbs().forEach{
        println(it)
    }
}