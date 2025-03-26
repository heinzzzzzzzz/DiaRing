package com.example.diaring.model

data class Meal(
    val name: String,
    val description: String,
    val calories: Int,
    val sugar: Double,
    val carbs: Double,
    val protein: Double,
    val fiber: Double,
    val ingredients: List<String>,
    val imageUrl: String
)

data class DailyMealPlan(
    val day: String,
    val breakfast: Meal,
    val lunch: Meal,
    val dinner: Meal,
    val snacks: List<Meal>
)

val filipinoMealPlans = listOf(
    DailyMealPlan(
        day = "Monday",
        breakfast = Meal(
            name = "Champorado with Sugar-Free Cocoa",
            description = "Traditional Filipino chocolate rice porridge made with sugar-free cocoa",
            calories = 250,
            sugar = 2.5,
            carbs = 45.0,
            protein = 6.0,
            fiber = 3.5,
            ingredients = listOf(
                "1 cup brown rice",
                "2 tbsp sugar-free cocoa powder",
                "1 cup low-fat milk",
                "Sugar substitute to taste"
            ),
            imageUrl = "champorado_image"
        ),
        lunch = Meal(
            name = "Tinolang Manok",
            description = "Chicken soup with ginger, green papaya, and moringa leaves",
            calories = 300,
            sugar = 1.5,
            carbs = 15.0,
            protein = 35.0,
            fiber = 4.0,
            ingredients = listOf(
                "200g chicken breast",
                "1 green papaya",
                "Moringa leaves",
                "Ginger",
                "Garlic and onion"
            ),
            imageUrl = "tinola_image"
        ),
        dinner = Meal(
            name = "Ginisang Monggo",
            description = "Sautéed mung beans with spinach",
            calories = 280,
            sugar = 1.0,
            carbs = 40.0,
            protein = 15.0,
            fiber = 8.0,
            ingredients = listOf(
                "1 cup mung beans",
                "2 cups spinach",
                "Garlic and onion",
                "1 tbsp fish sauce"
            ),
            imageUrl = "monggo_image"
        ),
        snacks = listOf(
            Meal(
                name = "Fresh Papaya",
                description = "Sliced fresh papaya",
                calories = 120,
                sugar = 8.0,
                carbs = 15.0,
                protein = 1.0,
                fiber = 3.0,
                ingredients = listOf("1 cup fresh papaya"),
                imageUrl = "papaya_image"
            )
        )
    )
    // Add more days here...
) 
