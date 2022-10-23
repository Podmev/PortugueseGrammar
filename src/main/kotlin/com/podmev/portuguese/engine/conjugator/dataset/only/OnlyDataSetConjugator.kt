package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.engine.conjugator.Conjugator
import com.podmev.portuguese.data.grammar.term.tense.GrammaticalTense
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo
import com.podmev.portuguese.data.grammar.term.verb.createVerbFormInfoWithVerbArgs
import com.podmev.portuguese.engine.dataset.verb.findInputVerbMeta
import com.podmev.portuguese.reader.convertInputVerbMetaToVerbFormInfoMap

//TODO make custom exceptions
/*uses only dataset, if there is no such tense throws exception*/
object OnlyDataSetConjugator : Conjugator {
    override fun conjugateVerb(
        verbInInfinitive: String,
        tense: GrammaticalTense,
        verbArgs: VerbArguments
    ): List<String> {
        val verbMeta =
            findInputVerbMeta(verbInInfinitive) ?: throw Exception("Verb $verbInInfinitive is not found in dataset")
        val verbFormInfoMap: Map<VerbFormInfo, String> = convertInputVerbMetaToVerbFormInfoMap(verbMeta)
        val currentVerbFormInfo = createVerbFormInfoWithVerbArgs(verbInInfinitive, tense, verbArgs)
        val verbInForm = verbFormInfoMap[currentVerbFormInfo] ?: throw Exception("Not found form $currentVerbFormInfo")
        if (verbInForm == "-") {
            throw Exception("This form doesn't exists $currentVerbFormInfo")
        }
        return verbVariantsSplit(verbInForm)
    }

    private fun verbVariantsSplit(maybeVerbForms: String): List<String> {
        val forms = maybeVerbForms.split(" - ")
        return forms.map { it.trim() }
    }

}

