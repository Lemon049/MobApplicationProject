package com.example.mobaplicationproject

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()
        val buttonFragment = findViewById<Button>(R.id.btnFragment)
        var isActive : Boolean = false

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragmentA)
            commit()
            isActive = true
        }

        buttonFragment.setOnClickListener{
            if (isActive == true)
            {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, fragmentB)
                    commit()
                    isActive = false
                }
            }
            else
            {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, fragmentA)
                    commit()
                    isActive = true
                }
            }


        }

    }
}