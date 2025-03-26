package com.example.diaring.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.diaring.model.Meal

@Composable
fun MealDetailsDialog(
    meal: Meal,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(meal.name) },
        text = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 8.dp)
            ) {
                Text(meal.description)
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    "Nutritional Information",
                    style = MaterialTheme.typography.titleMedium
                )
                Text("Calories: ${meal.calories}")
                Text("Sugar: ${meal.sugar}g")
                Text("Carbs: ${meal.carbs}g")
                Text("Protein: ${meal.protein}g")
                Text("Fiber: ${meal.fiber}g")
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    "Ingredients",
                    style = MaterialTheme.typography.titleMedium
                )
                meal.ingredients.forEach { ingredient ->
                    Text("• $ingredient")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}

@Composable
fun NutritionValue(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
} 
