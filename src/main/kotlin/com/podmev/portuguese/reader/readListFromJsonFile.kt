package com.podmev.portuguese.reader

import com.podmev.portuguese.utils.file.getFilesFromDirectory
import org.json.JSONArray
import java.io.File

fun readListFromDirectoryWithJsonFiles(file: File): List<String>{
    return readListFromJsonFiles(getFilesFromDirectory(file))
}

/*https://www.baeldung.com/kotlin/list-files-recursively
* */
fun readListFromJsonFiles(files: List<File>): List<String>{
    return files.flatMap{readListFromJsonFile(it)}
}

/*
* https://www.baeldung.com/kotlin/read-file
* */
fun readListFromJsonFile(file: File): List<String>{
    return readListFromJsonString(file.readText(Charsets.UTF_8))
}

/*
https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
http://theoryapp.com/parse-json-in-java/
 */
fun readListFromJsonString(string: String): List<String>{
    val arr = JSONArray(string)
    val list = mutableListOf<String>()
    for (i in 0 until arr.length()) {
        list.add(arr.getString(i))
    }
    return list
}



