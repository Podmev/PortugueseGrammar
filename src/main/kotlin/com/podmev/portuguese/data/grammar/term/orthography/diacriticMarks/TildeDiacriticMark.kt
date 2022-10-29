package com.podmev.portuguese.data.grammar.term.orthography.diacriticMarks

import com.podmev.portuguese.data.grammar.term.orthography.AbstractDiacriticMark

object TildeDiacriticMark : AbstractDiacriticMark() {
    override val englishTerm: String = "Tilde"
    override val shortEnglishTerm: String = "Tilde"
    override val portugueseTerm: String = "Til"
    override val symbol: String = "◌̃"
    override val obsolete: Boolean = false
    override val meaning: String =
        "The tilde marks nasal vowels before glides such as in cãibra and nação, " +
                "at the end of words, before final -s, and in some compounds: romãzeira \"pomegranate tree\", " +
                "from romã \"pomegranate\", and vãmente \"vainly\", from vã \"vain\". " +
                "It usually coincides with the stressed vowel unless there is an acute or circumflex accent " +
                "elsewhere in the word or if the word is compound: órgão \"organ\", " +
                "irmã + -zinha (\"sister\" + diminutive suffix) = irmãzinha \"little sister\". " +
                "The form õ is used only in the plurals of nouns ending in -ão (nação → nações) " +
                "and in the second person singular and third person forms of the verb pôr " +
                "in the present tense (pões, põe, põem)."
}