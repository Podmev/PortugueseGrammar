package com.podmev.portuguese.data.grammar.term.orthography
/*describing symbol of letter(with or no diacritics), lowercase and uppercase are different*/
data class ExactLetter(
    val genericLetter: GenericLetter,
    val size: LetterSize
){
    val view = genericLetter.viewBySize(size)
}
