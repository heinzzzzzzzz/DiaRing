package com.example.diaring.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diaring.ui.screens.HomeScreen
import com.example.diaring.ui.screens.FoodPlannerScreen
import com.example.diaring.ui.screens.ActivityRecommendationsScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object FoodPlanner : Screen("food_planner")
    data object ActivityRecommendations : Screen("activity_recommendations")
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.FoodPlanner.route) {
            FoodPlannerScreen(navController)
        }
        composable(Screen.ActivityRecommendations.route) {
            ActivityRecommendationsScreen(navController)
        }
    }
}