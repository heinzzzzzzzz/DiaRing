package com.example.diaring.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diaring.model.ActivityIntensity
import com.example.diaring.model.diabeticActivities

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityRecommendationsScreen(navController: NavController) {
    var selectedIntensity by remember { mutableStateOf<ActivityIntensity?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Activity Recommendations") },
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
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActivityIntensity.values().forEach { intensity ->
                    Button(
                        onClick = { selectedIntensity = intensity },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedIntensity == intensity)
                                MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text(intensity.name)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            selectedIntensity?.let { intensity ->
                diabeticActivities[intensity]?.forEach { activity ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = activity.name,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(activity.description)
                            Text("Duration: ${activity.duration}")
                            Text("Calories: ${activity.caloriesBurnedPerHour}/hour")
                        }
                    }
                }
            }
        }
    }
}
