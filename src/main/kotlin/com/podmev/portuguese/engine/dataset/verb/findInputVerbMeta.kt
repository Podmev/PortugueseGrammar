package com.podmev.portuguese.engine.dataset.verb

import com.podmev.portuguese.data.input.InputVerbMeta
import com.podmev.portuguese.utils.consts.RESOURCES_PATH
import java.io.File

fun findInputVerbMeta(verb: String): InputVerbMeta? {
    val normalizedVerb = verb.trim().toLowerCase()
    val firstLetter = normalizedVerb.subSequence(0,1)
    val verbPath = "${RESOURCES_PATH}portuguese/content/${firstLetter}/${normalizedVerb}.json"
    val file = File(verbPath)
    if(!file.isFile){
        return null
    }
    return parseInputVerbMetaFromFile(file)
}