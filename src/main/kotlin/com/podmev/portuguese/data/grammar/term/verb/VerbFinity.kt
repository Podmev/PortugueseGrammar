package com.podmev.portuguese.data.grammar.term.verb

/* property of verb to be finite or infinite
*
* Traditionally, a finite verb (from Latin: fīnītus, past participle of fīnīre – to put an end to, bound, limit)[1]
* is the form "to which number and person appertain",[2]: 125  in other words,
* those inflected for number and person.[3]
* Verbs were originally said to be finite if their form limited the possible person and number of the subject.
*
* A nonfinite verb is a derivative form of a verb unlike finite verbs.
* Accordingly, nonfinite verb forms are inflected for neither number nor person,
* and they cannot perform action as the root of an independent clause.[1]
* In English, nonfinite verbs include infinitives, participles and gerunds.
* Nonfinite verb forms in some other languages include converbs, gerundives and supines.
* */
enum class VerbFinity {
    FINITE,
    INFINITE
}