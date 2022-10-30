package com.podmev.portuguese.engine.conjugator.analytic

object VerbHelper {
    /*drop the last letter 'r' of infinitive*/
    fun dropInfinitiveSuffixR(infinitive: String):String = infinitive.dropLast(1)
}