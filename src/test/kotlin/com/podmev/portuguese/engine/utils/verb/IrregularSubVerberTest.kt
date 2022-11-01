package com.podmev.portuguese.engine.utils.verb

import com.google.common.truth.Truth
import com.podmev.portuguese.data.grammar.term.orthography.letters.E_Letter
import com.podmev.portuguese.data.grammar.term.orthography.letters.I_Letter
import com.podmev.portuguese.engine.utils.verb.searchRules.DiacriticsRule
import com.podmev.portuguese.engine.utils.verb.searchRules.LetterInFrontRule
import com.podmev.portuguese.engine.utils.verb.searchRules.PreparingRule
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class IrregularSubVerberTest {
    val simpleIrregularFormMap: Map<String, String> = mapOf(
        Pair("abrir", "aberto"),
        Pair("dizer", "dito"),
        Pair("doer", "doído"),
        Pair("escrever", "escrito"),
        Pair("fazer", "feito"),
        Pair("moer", "moído"),
        Pair("pôr", "posto"),
        Pair("prender", "preso"),
        Pair("revolver", "revolto"),
        Pair("roer", "roído"),
        Pair("soer", "soído"),
        Pair("ver", "visto"),
        Pair("vir", "vindo")
    )

    private val preparingRules: List<PreparingRule> = listOf(
        LetterInFrontRule(I_Letter),
        LetterInFrontRule(E_Letter),
        DiacriticsRule
    )

    val irregularSubVerber: IrregularSubVerber = SuffixTreeIrregularSubVerber(simpleIrregularFormMap, preparingRules)

    @Nested
    inner class FindNonEmptySuffix{
        @Test
        fun adoptar(){
            Truth.assertThat(irregularSubVerber.findNonEmptySuffix("adoptar")).isNull()
        }
    }

    @Nested
    inner class IsIrregularVerb(){
        @Test
        fun adoptarFalse(){
            Truth.assertThat(irregularSubVerber.isIrregularVerb("adoptar")).isFalse()
        }

        @Test
        fun provirFalse(){
            Truth.assertThat(irregularSubVerber.isIrregularVerb("provir")).isTrue()
        }
    }

    @Nested
    inner class GetIrregularForm{
        @Test
        fun adoptarNull(){
            Truth.assertThat(irregularSubVerber.getIrregularForm("adoptar")).isNull()
        }

        @Test
        fun provirProvindo(){
            Truth.assertThat(irregularSubVerber.getIrregularForm("provir")).isEqualTo("provindo")
        }
    }

}