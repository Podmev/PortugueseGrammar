package com.podmev.portuguese.engine.dataset.verb

import com.podmev.portuguese.reader.readListFromDirectoryWithJsonFiles
import com.podmev.portuguese.utils.consts.RESOURCES_PATH
import java.io.File

/*Receive all verbs in infinitive form from resources*/
fun getAllVerbs(): List<String> {
    val verbListPath = "${RESOURCES_PATH}portuguese/categories"
    return readListFromDirectoryWithJsonFiles(File(verbListPath))
}