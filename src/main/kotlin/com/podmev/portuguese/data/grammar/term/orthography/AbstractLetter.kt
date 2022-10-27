package com.podmev.portuguese.data.grammar.term.orthography

abstract class AbstractLetter(): Letter {
    override fun toString(): String  = "${uppercase}_Letter"
}