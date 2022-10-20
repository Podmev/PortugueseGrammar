package com.podmev.portuguese.engine.dataset.verb

import com.podmev.portuguese.reader.readListFromDirectoryWithJsonFiles
import java.io.File

/*Receive all verbs in infinitive form from resources*/
fun getAllVerbs(): List<String> {
    val verbListPath = "src/main/resources/portuguese/categories"
    return readListFromDirectoryWithJsonFiles(File(verbListPath))
}