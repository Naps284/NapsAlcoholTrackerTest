package com.example.napsalcoholtrackertest.data

import kotlinx.coroutines.flow.Flow

class AlcoholRepository(private val alcoholEntryDao: AlcoholEntryDao) {

    // Get all alcohol entries from the database
    val allEntries: Flow<List<AlcoholEntry>> = alcoholEntryDao.getAllEntries()

    // Insert a new alcohol entry into the database
    suspend fun insert(entry: AlcoholEntry) {
        alcoholEntryDao.insert(entry)
    }

    // Delete an alcohol entry from the database
    suspend fun delete(entry: AlcoholEntry) {
        alcoholEntryDao.delete(entry)
    }
}


//The repository provides a clean API for accessing data to the rest of the application.
//It uses the DAO (AlcoholEntryDao) to interact with the database.
//allEntries: A Flow that emits a list of AlcoholEntry objects from the database.
//insert: A suspend function to insert a new AlcoholEntry.
//delete: A suspend function to delete an AlcoholEntry.
