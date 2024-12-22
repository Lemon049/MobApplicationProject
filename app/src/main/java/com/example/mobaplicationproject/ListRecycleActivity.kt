package com.example.mobaplicationproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListRecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycle_list_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            FoodItem("Black Karaage with Curry Bento", "Crispy black karaage...", R.drawable.food1),
            FoodItem("Seafood Udon", "Quick and easy to prepare...", R.drawable.food2),
            FoodItem("Tonkotsu Ramen", "Noodle soup dish originated in Fukuoka...", R.drawable.food3),
            FoodItem("Takoyaki", "Ball-shaped snack made of batter...", R.drawable.food4),
            FoodItem("Tempura", "Consists of seafood and vegetables...", R.drawable.food5),
            FoodItem("Yakitori Shrimp", "Is a Japanese dish that consists of skewered and grilled chicken. However, it ca..", R.drawable.food6)
        )

        val adapter = FoodAdapter(foodList, this)
        recyclerView.adapter = adapter
    }
}