package com.example.diaring.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diaring.model.Activity
import com.example.diaring.model.ActivityIntensity
import com.example.diaring.model.diabeticActivities
import com.google.android.material.icons.Icons
import com.google.android.material.icons.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityRecommendationsScreen(navController: NavController) {
    var selectedIntensity by remember { mutableStateOf<ActivityIntensity?>(null) }

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
                    .padding(16.dp)
            ) {
                // Intensity selector
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActivityIntensity.values().forEach { intensity ->
                        ElevatedButton(
                            onClick = { selectedIntensity = intensity },
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = if (selectedIntensity == intensity)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                        ) {
                            Text(intensity.name)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Activities list
                selectedIntensity?.let { intensity ->
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(diabeticActivities[intensity] ?: emptyList()) { activity ->
                            ActivityCard(activity = activity)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ActivityCard(activity: Activity) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = activity.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            
            Text(
                text = activity.description,
                style = MaterialTheme.typography.bodyMedium
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Benefits:",
                style = MaterialTheme.typography.titleMedium
            )
            
            activity.benefits.forEach { benefit ->
                Text("• $benefit")
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Duration: ${activity.duration}")
                Text("Calories: ${activity.caloriesBurnedPerHour}/hour")
            }
        }
    }
} 
} 
