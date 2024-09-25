package com.example.napsalcoholtrackertest.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlcoholEntry::class], version = 1, exportSchema = false)
abstract class AlcoholTrackerDatabase : RoomDatabase() {
    abstract fun alcoholEntryDao(): AlcoholEntryDao
}


// The @Database annotation includes the list of entities (AlcoholEntry) and the version of the database (version = 1).

//The alcoholEntryDao() function provides access to the DAO interface (AlcoholEntryDao).
