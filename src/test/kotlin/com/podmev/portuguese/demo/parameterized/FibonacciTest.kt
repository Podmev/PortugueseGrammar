package com.podmev.portuguese.demo.parameterized

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*


@RunWith(Parameterized::class)
class FibonacciTest(private val fInput: Int, private val fExpected: Int) {
    @Test
    fun test() {
        Assert.assertEquals(fExpected, Fibonacci.compute(fInput))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        public fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0, 0),
                arrayOf(1, 1),
                arrayOf(2, 1),
                arrayOf(3, 2),
                arrayOf(4, 3),
                arrayOf(5, 5),
                arrayOf(6, 8)
            )
        }
    }
}