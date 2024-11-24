package com.example.xyz

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {

    @Test
    fun testEmptyEmail() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("")

        assert(isEmailValid)
    }

    @Test
    fun testWrongEmail() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("invalidEmail")

        assert(isEmailValid)
    }

    @Test
    fun testProperEmail() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("example@mail.com")

        assert(isEmailValid)
    }

    @Test
    fun testEmptyPassword() {
        val credentialsManager = CredentialsManager()
        val isPasswordValid = credentialsManager.isPasswordValid("")

        assert(isPasswordValid)
    }

    @Test
    fun testProperPassword() {
        val credentialsManager = CredentialsManager()
        val isPasswordValid = credentialsManager.isPasswordValid("987654321")

        assert(isPasswordValid)
    }
}
