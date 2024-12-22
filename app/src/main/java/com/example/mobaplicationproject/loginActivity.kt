package com.example.mobaplicationproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.xyz.CredentialsManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.view.View


class loginActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        val loginNextBtn = findViewById<Button>(R.id.loginNextBtn)
        val loginEmailInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
        val loginPasswordInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
        val registerText = findViewById<TextView>(R.id.RegisterNowTxt)
        val loginTextField = findViewById<TextInputEditText>(R.id.loginEmailTextField)
        val passwordTextField = findViewById<TextInputEditText>(R.id.loginPasswordTextField)

        credentialsManager.userData["aboba@gmail.com"] = "neponimanie"
        loginNextBtn.setOnClickListener {
            val email = loginTextField.text.toString()
            val password = passwordTextField.text.toString()

            var isValid = true

            if (!credentialsManager.isEmailValid(email)) {
                loginEmailInputLayout.error = "Invalid email"
                isValid = false
            }
            else {
                loginEmailInputLayout.error = null
            }

            if (!credentialsManager.isPasswordValid(password)) {
                loginPasswordInputLayout.error = "Password cannot be empty"
                isValid = false
            }
            else {
                loginPasswordInputLayout.error = null
            }

            val success = credentialsManager.loginUser(email, password)


        }

        registerText.setOnClickListener {
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
        }
    }
}