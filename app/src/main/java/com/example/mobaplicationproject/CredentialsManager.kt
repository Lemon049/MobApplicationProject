// Put your package name here. Check your activity for reference.
package com.example.xyz

class CredentialsManager {

    // Method to validate email format
    fun isEmailValid(email: String): Boolean {

        return email.contains("@") && email.contains(".") && email.length > 5
    }

    // Method to validate password
    fun isPasswordValid(password: String): Boolean {

        return password.isNotEmpty() && password.length >= 8
    }
}
