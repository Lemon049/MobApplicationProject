package com.example.mobaplicationproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.xyz.CredentialsManager
import com.google.android.material.textfield.TextInputLayout

class FragmentA : Fragment(R.layout.register_screen) {
    private val credentialsManager = CredentialsManager()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logIn = view.findViewById<TextView>(R.id.LogInTxt)
        val registerButton = view.findViewById<Button>(R.id.registerNextBtn)
        val emailInputLayout = view.findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
        val passwordInputLayout = view.findViewById<TextInputLayout>(R.id.textInputLayoutPassword)

        registerButton.setOnClickListener {
            val email = emailInputLayout.editText?.text.toString().trim()
            val password = passwordInputLayout.editText?.text.toString().trim()

            var isValid = true

            if (!credentialsManager.isEmailValid(email)) {
                emailInputLayout.error = "Invalid email"
                isValid = false
            } else {
                emailInputLayout.error = null
            }

            if (!credentialsManager.isPasswordValid(password)) {
                passwordInputLayout.error = "Password cannot be empty"
                isValid = false
            } else {
                passwordInputLayout.error = null
            }

            if (isValid) {
                val registrationSuccess = credentialsManager.registerUser(email, password)
                if (registrationSuccess) {
                    (requireActivity() as? activity_with_fragment)?.switchToLoginFragment()
                } else {
                    emailInputLayout.error = "Email already taken"
                }
            }
        }

        logIn.setOnClickListener {
            (requireActivity() as? activity_with_fragment)?.switchToLoginFragment()
        }
    }
}