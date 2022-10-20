package com.podmev.portuguese.data.input

data class InputVerbMeta(
    var conjugations: List<Conjugation>? = listOf(),
    var definitions: List<String>? = listOf(),
    var description: String? = "",
    var etymology: String? = "",
    var page_id: Int = 0,
    var pronunciations: List<String>? = listOf(),
    var related: List<Any>? = listOf(),
    var synonyms: List<Any>? = listOf(),
    var url: String? = "",
    var word: String = ""
)