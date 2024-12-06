package com.example.xyz

class CredentialsManager {

    val userData = mutableMapOf<String, String>()

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