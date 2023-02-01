package com.podmev.portuguese.engine.dataset.verb

import com.podmev.portuguese.data.input.InputVerbMeta
import com.podmev.portuguese.utils.consts.RESOURCES_PATH
import java.io.File

fun findInputVerbMeta(verb: String): InputVerbMeta? {
    val file = getVerbFile(verb)?: return null
    return parseInputVerbMetaFromFile(file)
}