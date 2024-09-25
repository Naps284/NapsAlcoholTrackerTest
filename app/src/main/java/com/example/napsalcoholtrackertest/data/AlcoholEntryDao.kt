package com.example.napsalcoholtrackertest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlcoholEntryDao {

    @Insert
    suspend fun insertAlcoholEntry(alcoholEntry: AlcoholEntry): Long // or List<Long> if inserting multiple entries

    @Query("SELECT * FROM alcohol_entries ORDER BY timeOfConsumption ASC")
    fun getAllEntries(): Flow<List<AlcoholEntry>> // Fix: Use Flow for real-time data

    @Query("DELETE FROM alcohol_entries")
    suspend fun deleteAllEntries(): Int // or void
}
