package com.example.mobaplicationproject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipesViewModel : ViewModel() {
    private val _foodList = listOf(
        FoodItem("Black Karaage with Curry Bento", "Crispy black karaage...", R.drawable.food1),
        FoodItem("Seafood Udon", "Quick and easy to prepare...", R.drawable.food2),
        FoodItem("Tonkotsu Ramen", "Noodle soup dish originated in Fukuoka...", R.drawable.food3),
        FoodItem("Takoyaki", "Ball-shaped snack made of batter...", R.drawable.food4),
        FoodItem("Tempura", "Consists of seafood and vegetables...", R.drawable.food5),
        FoodItem("Yakitori Shrimp", "Is a Japanese dish that consists of skewered and grilled chicken...", R.drawable.food6)
    )

    private val _filteredFoodList = MutableStateFlow(_foodList)
    val filteredFoodList: StateFlow<List<FoodItem>> = _filteredFoodList.asStateFlow()

    fun filter(query: String) {
        if (query.length < 3) {
            _filteredFoodList.update { _foodList }
        } else {
            val lowerCaseQuery = query.lowercase()
            _filteredFoodList.update {
                _foodList.filter {
                    it.title.lowercase().contains(lowerCaseQuery) ||
                            it.description.lowercase().contains(lowerCaseQuery)
                }
            }
        }
    }
}
