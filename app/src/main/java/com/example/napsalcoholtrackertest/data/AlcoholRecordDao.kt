package com.example.napsalcoholtrackertest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlcoholRecordDao {

    @Insert
    suspend fun insertRecord(record: Record): Long // or List<Long> if inserting multiple

    @Query("SELECT * FROM alcohol_record")
    fun getAllRecords(): Flow<List<AlcoholRecord>> // Fix: Use Flow for real-time data
}
