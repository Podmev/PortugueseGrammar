package com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks

import com.podmev.portuguese.data.grammar.term.orthography.DiacriticMark

object UmlautDiacriticMark : DiacriticMark {
    override val englishTerm: String = "Umlaut"
    override val portugueseTerm: String = "Trema"
    override val symbol: String = "◌̈"
    override val obsolete: Boolean = true
    override val meaning: String =
        "The letters with diaeresis are nowadays practically in disuse. " +
                "Until 2009 they were still used in Brazilian Portuguese " +
                "in the combinations güe/qüe and güi/qüi " +
                "(European Portuguese in this case used the grave accent between 1911 and 1945, then abolished). " +
                "In old orthography they were also used as in English, French and Dutch to separate diphthongs " +
                "(e.g.: Raïnha, Luïsa,[9] saüde and so on). The other way to separate diphthongs and " +
                "non-hiatic vowel combinations is to use acute (as in modern saúde) or " +
                "circumflex (as in old-style Corôa)."
}