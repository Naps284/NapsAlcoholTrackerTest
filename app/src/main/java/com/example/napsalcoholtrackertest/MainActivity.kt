package com.example.napsalcoholtrackertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.napsalcoholtrackertest.ui.theme.NapsAlcoholTrackerTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NapsAlcoholTrackerTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlcoholTrackerForm()
                }
            }
        }
    }
}

@Composable
fun AlcoholTrackerForm() {
    // State variables to hold the input
    var beverage by remember { mutableStateOf("") }
    var concentration by remember { mutableStateOf("") }
    var volume by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Input fields
        OutlinedTextField(
            value = beverage,
            onValueChange = { beverage = it },
            label = { Text("Beverage Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = concentration,
            onValueChange = { concentration = it },
            label = { Text("Alcohol Concentration (%)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = volume,
            onValueChange = { volume = it },
            label = { Text("Volume (ml)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time of Consumption (HH:MM or t+)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Submit button
        Button(
            onClick = {
                if (beverage.isEmpty() || concentration.isEmpty() || volume.isEmpty() || time.isEmpty()) {
                    // Handle empty fields
                } else {
                    // For now, simply print the data
                    println("Data Submitted: $beverage, $concentration%, $volume ml at $time")
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlcoholTrackerFormPreview() {
    NapsAlcoholTrackerTestTheme {
        AlcoholTrackerForm()
    }
}
