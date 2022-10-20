package com.podmev.portuguese.engine.dataset.verb

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.podmev.portuguese.data.input.InputVerbMeta
import com.podmev.portuguese.utils.consts.RESOURCES_PATH
import com.podmev.portuguese.utils.file.getFilesFromDirectory
import com.podmev.portuguese.utils.file.readTextFromFile
import java.io.File

fun getAllInputVerbMetas(): List<InputVerbMeta> {
    val verbMetasPath = "${RESOURCES_PATH}portuguese/content"
    val verbMetasSeparateFiles = getFilesFromDirectory(File(verbMetasPath))
    return verbMetasSeparateFiles.map { parseInputVerbMetaFromFile(it) }
}

fun parseInputVerbMetaFromFile(file: File): InputVerbMeta {
//    val mapper = jacksonObjectMapper()
    val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
    val inputVerbMeta: InputVerbMeta = mapper.readValue(readTextFromFile(file))
    return inputVerbMeta
}

/*some kind of hack
* https://stackoverflow.com/questions/52238211/kotlin-objectmapper-readvalue-with-typereferencehashmapstring-string-can
* */
inline fun <reified T> ObjectMapper.readValue(s: String): T = this.readValue(s, object : TypeReference<T>() {})