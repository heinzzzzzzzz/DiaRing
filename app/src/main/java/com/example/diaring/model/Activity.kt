package com.example.diaring.model

data class Activity(
    val id: Int,
    val name: String,
    val description: String,
    val duration: String, // e.g., "30 minutes"
    val intensity: ActivityIntensity,
    val caloriesBurned: Int,
    val isRecommended: Boolean = true
)

enum class ActivityIntensity {
    LIGHT,
    MODERATE,
    VIGOROUS
} 