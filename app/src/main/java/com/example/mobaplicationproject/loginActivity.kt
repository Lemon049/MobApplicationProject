package com.example.mobaplicationproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.xyz.CredentialsManager
import com.google.android.material.textfield.TextInputLayout

class loginActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        val loginNextBtn = findViewById<Button>(R.id.loginNextBtn)
        val loginEmailInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
        val loginPasswordInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
        val registerText = findViewById<TextView>(R.id.RegisterNowTxt)

        loginNextBtn.setOnClickListener {
            val email = loginEmailInputLayout.editText?.text.toString().trim()
            val password = loginPasswordInputLayout.editText?.text.toString().trim()

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

            //Check hardcoded stuff
            if (isValid && credentialsManager.hardcoddedEmailPassword(email, password)) {
                val intent = Intent(this, emptyActivity::class.java)
                startActivity(intent)
            }
            else if (isValid) {
                loginPasswordInputLayout.error = "Invalid email or password"
            }
        }

        registerText.setOnClickListener {
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
        }
    }
}