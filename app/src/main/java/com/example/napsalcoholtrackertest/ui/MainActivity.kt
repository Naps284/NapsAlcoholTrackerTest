package com.example.napsalcoholtrackertest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.napsalcoholtrackertest.ui.theme.NapsAlcoholTrackerTestTheme
import com.example.napsalcoholtrackertest.data.*

class MainActivity : ComponentActivity() {

    // Lazy initialization of the ViewModel
    private val alcoholViewModel: AlcoholViewModel by viewModels {
        AlcoholViewModelFactory(
            AlcoholRepository(
                AlcoholTrackerDatabase.getDatabase(applicationContext).alcoholEntryDao()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NapsAlcoholTrackerTestTheme {
                // Pass the ViewModel to the Composable function
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlcoholTrackerForm(alcoholViewModel)
                }
            }
        }
    }
}

@Composable
fun AlcoholTrackerForm(viewModel: AlcoholViewModel) {
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
                    // Handle empty fields (e.g., show a Snackbar or Toast)
                } else {
                    // Use the ViewModel to save the data
                    val entry = AlcoholEntry(
                        name = beverage,
                        concentration = concentration.toDouble(),
                        volume = volume.toInt(),
                        time = time
                    )
                    viewModel.insert(entry)
                    // Clear the fields
                    beverage = ""
                    concentration = ""
                    volume = ""
                    time = ""
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
        AlcoholTrackerForm(viewModel = AlcoholViewModel(AlcoholRepository(AlcoholEntryDaoFake())))
    }
}
