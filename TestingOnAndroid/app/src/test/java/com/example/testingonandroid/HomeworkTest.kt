package com.example.testingonandroid

import com.google.common.truth.Truth
import org.junit.Test

class HomeworkTest {

    @Test
    fun `Returns 0 if n is 0`() {
        val result = Homework.fib(0)
        Truth.assertThat(result).isEqualTo(0)
    }

    @Test
    fun `Returns 1 if n is 1`() {
        val result = Homework.fib(1)
        Truth.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `Returns the correct value of fib(2)`() {
        val result = Homework.fib(2)
        Truth.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `Returns the correct value of fib(3)`() {
        val result = Homework.fib(3)
        Truth.assertThat(result).isEqualTo(2)
    }

    @Test
    fun `(a * b) returns true`() {
        val result = Homework.checkBraces("(a*b)")
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun `(a * b)) returns false`() {
        val result = Homework.checkBraces("(a*b))")
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `(a * b))( returns false`() {
        val result = Homework.checkBraces("(a*b))(")
        Truth.assertThat(result).isFalse()
    }

}