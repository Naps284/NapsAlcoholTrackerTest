package com.example.napsalcoholtrackertest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DrinkDao {

    @Insert
    suspend fun insertDrink(drink: Drink) // Fix: Return inserted row ID as Long

    @Query("SELECT * FROM drinks ORDER BY timeOfConsumption ASC")
    fun getAllDrinks(): Flow<List<Drink>> // Fix: Use Flow for real-time data

    @Query("DELETE FROM drinks")
    suspend fun deleteAllDrinks(): Int // Fix: Return the number of rows deleted
}
