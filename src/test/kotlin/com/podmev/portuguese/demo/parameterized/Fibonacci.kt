package com.podmev.portuguese.demo.parameterized

object Fibonacci {
    fun compute(n: Int): Int {
        val result: Int = if (n <= 1) {
            n
        } else {
            compute(n - 1) + compute(n - 2)
        }
        return result
    }
}