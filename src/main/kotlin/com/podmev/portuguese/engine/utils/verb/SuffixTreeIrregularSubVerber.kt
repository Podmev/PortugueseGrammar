package com.podmev.portuguese.engine.utils.verb

import com.podmev.portuguese.engine.utils.verb.searchRules.PreparingRule
import com.podmev.portuguese.utils.structure.suffixTreeMap.suffixTreeMapOf

class SuffixTreeIrregularSubVerber(
    verbFormMap: Map<String, String>,
    preparingRules: List<PreparingRule>
) : IrregularSubVerber {

    private val suffixTreeMap = suffixTreeMapOf<String>(
        prepareMap(verbFormMap, preparingRules)
    )

    override fun findNonEmptySuffix(verb: String): String? {
        val suffix = getLongestSuffix(verb)
        if (suffix.isEmpty()) {
            return null
        }
        return suffix
    }

    override fun isIrregularVerb(verb: String): Boolean = getLongestSuffix(verb).isNotEmpty()

    override fun getIrregularForm(verb: String): String? {
        val suffix = findNonEmptySuffix(verb) ?: return null
        val suffixForm = suffixTreeMap[suffix]!!
        if (suffix == verb) {
            return suffixForm
        }
        val prefix = verb.dropLast(suffix.length)
        return prefix + suffixForm
    }

    private fun getLongestSuffix(verb: String): String = suffixTreeMap.findLongestSuffix(verb)

    private fun prepareMap(
        verbFormMap: Map<String, String>,
        preparingRules: List<PreparingRule>,
//        prepareEntry: (key: String, value: String) -> List<Pair<String, String>>
    ): Map<String, String> {
        val map = mutableMapOf<String, String>()
        for ((key, value) in verbFormMap) {
            for ((newKey, newValue) in prepareEntry(key, value, preparingRules)) {
                map[newKey] = newValue
            }
        }
        return map
    }

    private fun prepareEntry(
        verb: String,
        form: String,
        preparingRules: List<PreparingRule>
    ):
            List<Pair<String, String>> {
        var result = listOf(Pair(verb, form))
        for (rule in preparingRules) {
            result = rule.prepareEntries(result)
        }
        return result
    }
}