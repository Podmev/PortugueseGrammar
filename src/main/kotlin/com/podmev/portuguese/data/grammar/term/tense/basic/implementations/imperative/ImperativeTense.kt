package com.podmev.portuguese.data.grammar.term.tense.basic.implementations.imperative

import com.podmev.portuguese.data.grammar.term.tense.basic.BasicTense

/*Note: there is affirmative and negative version, but there is no need to use in model*/
object ImperativeTense : BasicTense(){
    override fun toString(): String {
        return "ImperativeTense"
    }
}