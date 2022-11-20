package com.podmev.portuguese.engine.conjugator.dataset.only

import com.podmev.portuguese.data.engine.conjugator.defaultConjugateSettings
import com.podmev.portuguese.data.grammar.term.general.GrammaticalGender
import com.podmev.portuguese.data.grammar.term.general.GrammaticalNumber
import com.podmev.portuguese.data.grammar.term.general.GrammaticalPerson
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.GerundTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.InfinitiveTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.PastParticipleForSerEstarTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.PastParticipleTense
import com.podmev.portuguese.data.grammar.term.tense.basic.implementations.indicative.IndicativeImperfectTense
import com.podmev.portuguese.data.grammar.term.verb.GrammaticalVoice
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class OnlyDataSetConjugatorTest {
    private val conjugator = OnlyDataSetConjugator

    @Test
    fun estarImperfectThirdPersonSingularMasculineTest() {
        val verbInForm: List<String> = conjugator.conjugateVerb(
            verbInInfinitive = "estar",
            tense = IndicativeImperfectTense,
            verbArgs = VerbArguments(
                person = GrammaticalPerson.THIRD,
                number = GrammaticalNumber.SINGULAR,
                gender = GrammaticalGender.MASCULINE,
                voice = GrammaticalVoice.ACTIVE
            ),
            settings = defaultConjugateSettings
        )
        Assertions.assertEquals(
            /* expected = */ listOf("estava"),
            /* actual = */ verbInForm,
            /* message = */ "Verb 'estar' in indicative imperfect for third person singular, masculine, active"
        )
    }

    @Test
    fun estarInfinitiveTest() {
        val verbInForm: List<String> = conjugator.conjugateVerb(
            verbInInfinitive = "estar",
            tense = InfinitiveTense,
            verbArgs = VerbArguments(
                person = GrammaticalPerson.UNDEFINED,
                number = GrammaticalNumber.UNDEFINED,
                gender = GrammaticalGender.UNDEFINED,
                voice = GrammaticalVoice.ACTIVE
            ),
            settings = defaultConjugateSettings
        )
        Assertions.assertEquals(
            /* expected = */ listOf("estar"),
            /* actual = */ verbInForm,
            /* message = */ "Verb 'estar' in infinitive"
        )
    }

    @Test
    fun fazerGerundTest() {
        val verbInForm: List<String> = conjugator.conjugateVerb(
            verbInInfinitive = "fazer",
            tense = GerundTense,
            verbArgs = VerbArguments(
                person = GrammaticalPerson.UNDEFINED,
                number = GrammaticalNumber.UNDEFINED,
                gender = GrammaticalGender.UNDEFINED,
                voice = GrammaticalVoice.ACTIVE
            ),
            settings = defaultConjugateSettings
        )
        Assertions.assertEquals(
            /* expected = */ listOf("fazendo"),
            /* actual = */ verbInForm,
            /* message = */ "Verb 'fazer' in gerund"
        )
    }

    @Nested
    inner class PastParticiple{
        @Test
        fun falarMasculineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("falado"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle masculine singular"
            )
        }

        @Test
        fun falarFeminineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("falada"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle feminine singular"
            )
        }

        @Test
        fun falarMasculinePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("falados"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle masculine plural"
            )
        }

        @Test
        fun falarFemininePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("faladas"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle feminine plural"
            )
        }

        @Test
        fun pagarMasculineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pagado"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle masculine singular"
            )
        }

        @Test
        fun pagarFeminineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pagada"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle feminine singular"
            )
        }

        @Test
        fun pagarMasculinePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pagados"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle masculine plural"
            )
        }

        @Test
        fun pagarFemininePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pagadas"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle feminine plural"
            )
        }
    }

    @Nested
    inner class PastParticipleSerEstar{
        @Test
        fun falarMasculineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("falado"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle for ser/estar masculine singular"
            )
        }

        @Test
        fun falarFeminineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("falada"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle for ser/estar feminine singular"
            )
        }

        @Test
        fun falarMasculinePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("falados"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle for ser/estar masculine plural"
            )
        }

        @Test
        fun falarFemininePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "falar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("faladas"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'falar' in past participle for ser/estar feminine plural"
            )
        }

        @Test
        fun pagarMasculineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pago"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle for ser/estar masculine singular"
            )
        }

        @Test
        fun pagarFeminineSingularTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.SINGULAR,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("paga"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle for ser/estar feminine singular"
            )
        }

        @Test
        fun pagarMasculinePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.MASCULINE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pagos"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle for ser/estar masculine plural"
            )
        }

        @Test
        fun pagarFemininePluralTest() {
            val verbInForm: List<String> = conjugator.conjugateVerb(
                verbInInfinitive = "pagar",
                tense = PastParticipleForSerEstarTense,
                verbArgs = VerbArguments(
                    person = GrammaticalPerson.UNDEFINED,
                    number = GrammaticalNumber.PLURAL,
                    gender = GrammaticalGender.FEMININE,
                    voice = GrammaticalVoice.ACTIVE
                ),
                settings = defaultConjugateSettings
            )
            Assertions.assertEquals(
                /* expected = */ listOf("pagas"),
                /* actual = */ verbInForm,
                /* message = */ "Verb 'pagar' in past participle for ser/estar feminine plural"
            )
        }
    }

}