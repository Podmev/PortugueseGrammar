package com.podmev.portuguese.utils.file

import java.io.File

fun writeStringToFile(file: File, string: String) {
    //creating parent directory if necessary
    file.parentFile.mkdirs()
    file.writeText(string, Charsets.UTF_8)
}