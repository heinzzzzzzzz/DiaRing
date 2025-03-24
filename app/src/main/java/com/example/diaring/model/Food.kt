package com.example.diaring.model

data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val calories: Int,
    val sugarContent: Double, // in grams
    val servingSize: String,
    val category: FoodCategory,
    val isRecommended: Boolean = true
)

enum class FoodCategory {
    BREAKFAST,
    LUNCH,
    DINNER,
    SNACK
} 