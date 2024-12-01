package com.example.xyz

class CredentialsManager {

    val userData = mutableMapOf<String, String>()

    fun isEmailValid(email: String): Boolean {
        return email.contains("@") && email.contains(".") && email.length > 5
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun hardcoddedEmailPassword(email: String, password: String): Boolean {
        return email == "test@te.st" && password == "1234"
    }

    fun registerUser(email: String, password: String): Boolean {
        if (isEmailValid(email) && isPasswordValid(password)) {
            if (userData.containsKey(email.lowercase())) {
                return false
            }
            userData[email.lowercase()] = password
            return true
        }
        return false
    }

    fun loginUser(email: String, password: String): Boolean {
        return userData[email] == password
    }
}