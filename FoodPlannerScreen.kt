package com.example.diaring.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diaring.model.filipinoMealPlans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodPlannerScreen(navController: NavController) {
    var selectedDay by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Food Planner") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            TabRow(selectedTabIndex = selectedDay) {
                filipinoMealPlans.forEachIndexed { index, plan ->
                    Tab(
                        selected = selectedDay == index,
                        onClick = { selectedDay = index },
                        text = { Text(plan.day) }
                    )
                }
            }

            val currentPlan = filipinoMealPlans[selectedDay]
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                MealSection("Breakfast", currentPlan.breakfast)
                MealSection("Lunch", currentPlan.lunch)
                MealSection("Dinner", currentPlan.dinner)
                if (currentPlan.snacks.isNotEmpty()) {
                    MealSection("Snacks", currentPlan.snacks[0])
                }
            }
        }
    }
}
