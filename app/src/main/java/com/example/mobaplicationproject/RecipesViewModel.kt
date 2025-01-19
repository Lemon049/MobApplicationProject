package com.example.mobaplicationproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UiState(
    val recipes: List<FoodItem> = emptyList(),
    val isLoading: Boolean = false
)

class RecipesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

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
        // Debounce mechanism and loading simulation
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            delay(300) // Simulates debounce
            delay(2000) // Simulates loading delay

            // Perform filtering
            val lowerCaseQuery = query.lowercase()
            val updatedFoodList = if (query.length < 3) {
                _foodList
            } else {
                _foodList.filter {
                    it.title.lowercase().contains(lowerCaseQuery) ||
                            it.description.lowercase().contains(lowerCaseQuery)
                }
            }

            // Update filtered list and reset loading state
            _filteredFoodList.update { updatedFoodList }
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}
