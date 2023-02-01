package com.podmev.portuguese.engine.dataset.verb
import com.podmev.portuguese.utils.file.readTextFromFile
import com.podmev.portuguese.utils.file.writeStringToFile

/*
* change adiantamos - adiantámos for adiantamos | adiantámos
* */
fun changeInputVerbFormat(verb: String) {
    val file = getVerbFile(verb) ?: return
    val metaFromFile = parseInputVerbMetaFromFile(file)
    val conjugation =
        metaFromFile.conjugations
            ?.find { conjugation -> conjugation.form == "p1" &&
                    conjugation.group == "indicative/preterite" &&
                    conjugation.value.contains("-")
            }
            ?: return
    val oldValue = conjugation.value
    val newValue = changeForm(oldValue)
    val text = readTextFromFile(file)
    val replacedText = text.replaceFirst(oldValue, newValue)
    writeStringToFile(file, replacedText)
}

fun replaceAllVerbs(){
    for(verb in getAllVerbs()){
        changeInputVerbFormat(verb)
    }
}

fun main(){
    replaceAllVerbs()
}

fun changeForm(value: String): String =
    value.replace("-", "|")
