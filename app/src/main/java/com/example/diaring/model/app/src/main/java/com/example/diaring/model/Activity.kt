package com.example.diaring.model

enum class ActivityIntensity {
    LIGHT, MODERATE, VIGOROUS
}

data class Activity(
    val name: String,
    val description: String,
    val intensity: ActivityIntensity,
    val caloriesBurnedPerHour: Int,
    val benefits: List<String>,
    val duration: String,
    val precautions: List<String>
)

val diabeticActivities = mapOf(
    ActivityIntensity.LIGHT to listOf(
        Activity(
            name = "Walking",
            description = "Gentle walk around your neighborhood or park",
            intensity = ActivityIntensity.LIGHT,
            caloriesBurnedPerHour = 150,
            benefits = listOf(
                "Improves blood circulation",
                "Helps lower blood sugar",
                "Low impact on joints"
            ),
            duration = "30 minutes",
            precautions = listOf(
                "Wear comfortable shoes",
                "Bring water",
                "Check blood sugar before and after"
            )
        ),
        Activity(
            name = "Tai Chi",
            description = "Gentle flowing movements with meditation",
            intensity = ActivityIntensity.LIGHT,
            caloriesBurnedPerHour = 120,
            benefits = listOf(
                "Improves balance",
                "Reduces stress",
                "Enhances flexibility"
            ),
            duration = "20 minutes",
            precautions = listOf(
                "Start slowly",
                "Follow instructor's guidance",
                "Monitor breathing"
            )
        )
    ),
    ActivityIntensity.MODERATE to listOf(
        Activity(
            name = "Swimming",
            description = "Pool swimming at moderate pace",
            intensity = ActivityIntensity.MODERATE,
            caloriesBurnedPerHour = 300,
            benefits = listOf(
                "Full body workout",
                "Low impact on joints",
                "Improves cardiovascular health"
            ),
            duration = "30 minutes",
            precautions = listOf(
                "Check blood sugar before swimming",
                "Don't swim alone",
                "Stay hydrated"
            )
        )
    ),
    ActivityIntensity.VIGOROUS to listOf(
        Activity(
            name = "Cycling",
            description = "Brisk cycling on stationary bike or outdoors",
            intensity = ActivityIntensity.VIGOROUS,
            caloriesBurnedPerHour = 400,
            benefits = listOf(
                "High calorie burn",
                "Strengthens leg muscles",
                "Improves heart health"
            ),
            duration = "20 minutes",
            precautions = listOf(
                "Monitor heart rate",
                "Stay hydrated",
                "Check blood sugar frequently"
            )
        )
    )
) 
