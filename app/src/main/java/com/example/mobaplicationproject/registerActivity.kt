package com.example.mobaplicationproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xyz.CredentialsManager
import com.google.android.material.textfield.TextInputEditText

class registerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val credentialsManager = CredentialsManager()
        val LoginText = findViewById<View>(R.id.LogInTxt)
        val registerButton = findViewById<Button>(R.id.registerNextBtn)
        val emailText = findViewById<TextInputEditText>(R.id.registerEmailTextField)
        val passwordText = findViewById<TextInputEditText>(R.id.registerPasswordTextField)

        LoginText.setOnClickListener{
            val intent = Intent(this@registerActivity, loginActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val username = emailText.text.toString()
            val password = passwordText.text.toString()
            val success = credentialsManager.registerUser(username, password)
            if (success) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                val goToLogin = Intent(this, loginActivity::class.java)
                startActivity(goToLogin)
            } else {
                Toast.makeText(this, "Registration failed: Invalid data or user exists", Toast.LENGTH_SHORT).show()
            }
        }

    }
}