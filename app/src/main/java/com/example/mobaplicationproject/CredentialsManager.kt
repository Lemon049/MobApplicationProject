package com.example.xyz

class CredentialsManager {

    fun isEmailValid(email: String): Boolean {
        return email.contains("@") && email.contains(".") && email.length > 5
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun hardcoddedEmailPassword(email: String, password: String): Boolean {
        return email == "test@te.st" && password == "1234"
    }
}