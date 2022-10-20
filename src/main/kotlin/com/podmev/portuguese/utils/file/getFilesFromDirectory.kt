package com.podmev.portuguese.utils.file

import java.io.File

fun getFilesFromDirectory(file: File): List<File>{
    val fileList = mutableListOf<File>()
    file.walkTopDown().forEach {
        if(it.isFile) {
            fileList.add(it)
        }
    }
    return fileList
}