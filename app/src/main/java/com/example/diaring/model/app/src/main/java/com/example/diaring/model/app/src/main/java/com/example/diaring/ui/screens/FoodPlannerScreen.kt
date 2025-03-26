package com.example.diaring.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnItem
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diaring.model.Meal
import com.example.diaring.model.filipinoMealPlans
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodPlannerScreen(navController: NavController) {
    var selectedDay by remember { mutableStateOf(0) }
    var showMealDetails by remember { mutableStateOf<Meal?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "DiaRing",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // Days selector
                ScrollableTabRow(
                    selectedTabIndex = selectedDay,
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    filipinoMealPlans.forEachIndexed { index, plan ->
                        Tab(
                            selected = selectedDay == index,
                            onClick = { selectedDay = index },
                            text = { Text(plan.day) }
                        )
                    }
                }

                // Meal plan content
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    val dailyPlan = filipinoMealPlans[selectedDay]
                    
                    item {
                        MealCard(
                            title = "Breakfast",
                            meal = dailyPlan.breakfast,
                            onSeeMore = { showMealDetails = it }
                        )
                    }
                    // Add other meals...
                }
            }
        }

        // Meal details dialog
        showMealDetails?.let { meal ->
            MealDetailsDialog(
                meal = meal,
                onDismiss = { showMealDetails = null }
            )
        }
    }
}

@Composable
private fun MealCard(
    title: String,
    meal: Meal,
    onSeeMore: (Meal) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            
            Text(
                text = meal.name,
                style = MaterialTheme.typography.titleMedium
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NutritionValue("Calories", meal.calories.toString())
                NutritionValue("Sugar", "${meal.sugar}g")
                NutritionValue("Carbs", "${meal.carbs}g")
            }

            Button(
                onClick = { onSeeMore(meal) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("See More")
            }
        }
    }
} 
