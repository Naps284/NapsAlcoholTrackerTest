package com.example.napsalcoholtrackertest.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlcoholRecord::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alcoholRecordDao(): AlcoholRecordDao
}
