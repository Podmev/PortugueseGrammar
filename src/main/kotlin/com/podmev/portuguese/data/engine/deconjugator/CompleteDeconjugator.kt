package com.podmev.portuguese.data.engine.deconjugator

import com.podmev.portuguese.data.grammar.term.verb.VerbFormInfo

interface CompleteDeconjugator {
    fun getVerbFormInfo(verbForm: String): List<VerbFormInfo>
}