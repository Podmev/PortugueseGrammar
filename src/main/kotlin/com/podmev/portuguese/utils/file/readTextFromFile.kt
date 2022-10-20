package com.podmev.portuguese.utils.file

import java.io.File

fun readTextFromFile(file: File): String = file.readText(Charsets.UTF_8)