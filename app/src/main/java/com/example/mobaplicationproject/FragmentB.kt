package com.example.mobaplicationproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.xyz.CredentialsManager
import com.google.android.material.textfield.TextInputLayout

class FragmentB : Fragment(R.layout.login_screen) {
    private val credentialsManager = CredentialsManager()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerNow = view.findViewById<TextView>(R.id.RegisterNowTxt)
        val loginEmail = view.findViewById<TextInputLayout>(R.id.loginEmailTextField)
        val loginPassword = view.findViewById<TextInputLayout>(R.id.loginPasswordTextField)
        val loginNextButton = view.findViewById<Button>(R.id.loginNextBtn)

        loginNextButton.setOnClickListener {
            val emailText = loginEmail.editText?.text.toString().trim()
            val passwordText = loginPassword.editText?.text.toString().trim()
            val correctEmail = "test@te.st"
            val correctPassword = "1234"

            loginEmail.error = null
            loginPassword.error = null

            if (!credentialsManager.isEmailValid(emailText)) {
                loginEmail.error = "Invalid email format"
                return@setOnClickListener
            }

            if (!credentialsManager.isPasswordValid(passwordText)) {
                loginPassword.error = "Password cannot be empty"
                return@setOnClickListener
            }

            val loginSuccessful = (emailText == correctEmail && passwordText == correctPassword) ||
                    credentialsManager.loginUser(emailText, passwordText)

            if (loginSuccessful) {
                // You can define any post-login action here if required
            } else {
                loginEmail.error = "Incorrect email or password"
                loginPassword.error = "Incorrect email or password"
            }
        }

        registerNow.setOnClickListener {
            (requireActivity() as? activity_with_fragment)?.switchToRegisterFragment()
        }
    }
}