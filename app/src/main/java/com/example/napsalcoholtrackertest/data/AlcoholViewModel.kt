package com.example.napsalcoholtrackertest.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AlcoholViewModel(private val repository: AlcoholRepository) : ViewModel() {

    // A Flow that represents the list of all alcohol entries
    val allEntries: Flow<List<AlcoholEntry>> = repository.allEntries

    // Function to insert a new alcohol entry
    fun insert(entry: AlcoholEntry) = viewModelScope.launch {
        repository.insert(entry)
    }

    // Function to delete an alcohol entry
    fun delete(entry: AlcoholEntry) = viewModelScope.launch {
        repository.delete(entry)
    }
}

// ViewModel Factory to instantiate AlcoholViewModel
class AlcoholViewModelFactory(private val repository: AlcoholRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlcoholViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlcoholViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


//AlcoholViewModel: This class provides data to the UI and acts as a communication center between the Repository and the UI.
//allEntries: A Flow that emits the list of alcohol entries.
//insert: A function to insert a new alcohol entry into the database.
//delete: A function to delete an existing alcohol entry from the database.
//AlcoholViewModelFactory: A factory class to instantiate the AlcoholViewModel with the necessary repository.
