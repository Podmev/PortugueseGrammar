package com.podmev.portuguese.engine.dataset.verb

import com.podmev.portuguese.reader.readListFromDirectoryWithJsonFiles
import com.podmev.portuguese.reader.readListFromJsonFile
import com.podmev.portuguese.utils.consts.RESOURCES_PATH
import java.io.File

/*Receive all irregular verbs in infinitive form from resources*/
fun getAllIrregularVerbs(): List<String> {
    val verbListPath = "${RESOURCES_PATH}portuguese/irregularVerbs.json"
    return readListFromJsonFile(File(verbListPath))
}