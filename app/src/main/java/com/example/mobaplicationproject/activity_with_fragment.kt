package com.example.mobaplicationproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class activity_with_fragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_with_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set the initial fragment
        supportFragmentManager.commit {
            replace<LoginFragment>(R.id.sampleActivity)
        }
    }

    fun switchToRegisterFragment() {
        supportFragmentManager.commit {
            replace<RegisterFragment>(R.id.sampleActivity)
            addToBackStack(null) // Enable back navigation
        }
    }

    fun switchToLoginFragment() {
        supportFragmentManager.commit {
            replace<LoginFragment>(R.id.sampleActivity)
            addToBackStack(null) // Enable back navigation
        }
    }
}