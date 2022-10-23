package com.podmev.portuguese.engine.dataset.verb

/*get all possible conjugation groups from dataset in resources*/
fun getAllConjugationGroups(): List<String> {
    val formSet = hashSetOf<String>()
    var count = 0
    for (verb in getAllVerbs()) {
        println("#${++count} $verb")
        val verbMeta = findInputVerbMeta(verb)
        for (conjugation in (verbMeta?.conjugations ?: emptyList())) {
            formSet.add(conjugation.group)
        }
    }
    return formSet.toList()
}