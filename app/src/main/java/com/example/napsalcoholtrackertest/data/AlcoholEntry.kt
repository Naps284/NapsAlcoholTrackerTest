package com.example.napsalcoholtrackertest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alcohol_entries")
data class AlcoholEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val beverageName: String,
    val alcoholPercentage: Double,
    val volume: Double,
    val timeOfConsumption: String
)
