package com.podmev.portuguese.engine.dataset.verb

import com.podmev.portuguese.reader.readListFromDirectoryWithJsonFiles
import com.podmev.portuguese.reader.readListFromJsonFile
import com.podmev.portuguese.utils.consts.RESOURCES_PATH
import java.io.File

/*Receive all defective verbs in infinitive form from resources*/
fun getAllDefectiveVerbs(): List<String> {
    val verbListPath = "${RESOURCES_PATH}portuguese/defectiveVerbs.json"
    return readListFromJsonFile(File(verbListPath))
}