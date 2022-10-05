package com.example.testingonandroid

import com.google.common.truth.Truth
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Erick",
            "123",
            "123"
        )
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun `username already exist returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Carl",
                "123",
            "123"
        )
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `password is empty returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Erick",
            "",
            ""
        )
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `password is repeated incorrectly returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Carl",
            "123",
            "1234"
        )
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Carl",
            "1",
            "1"
        )
        Truth.assertThat(result).isFalse()
    }
    
}