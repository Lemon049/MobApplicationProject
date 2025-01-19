package com.example.xyz

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CredentialsManager {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    val userData = mutableMapOf<String, String>()

    // Validates email format
    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false

        val emailPattern = ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+")
        val regex = Regex(emailPattern)

        return regex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun hardcodedEmailPassword(email: String, password: String): Boolean {
        return email == "test@te.st" && password == "1234"
    }

    fun registerUser(email: String, password: String): Boolean {
        if (isEmailValid(email) && isPasswordValid(password)) {
            if (userData.containsKey(email.lowercase())) {
                return false // Email already registered
            }
            userData[email.lowercase()] = password
            return true
        }
        return false
    }

    fun loginUser(email: String, password: String): Boolean {
        val success = userData[email.lowercase()] == password
        _isLoggedIn.value = success // Update login state
        return success
    }

    fun logoutUser() {
        _isLoggedIn.value = false // Update login state
    }

    fun resetPassword(email: String, newPassword: String): Boolean {
        if (isEmailValid(email) && isPasswordValid(newPassword)) {
            if (userData.containsKey(email.lowercase())) {
                userData[email.lowercase()] = newPassword
                return true
            }
        }
        return false
    }

    fun isUserLoggedIn(): Boolean {
        return _isLoggedIn.value
    }
}