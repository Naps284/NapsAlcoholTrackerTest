package com.example.napsalcoholtrackertest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinks")
data class Drink(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val alcoholContent: Float,
    val volume: Int,
    val timeOfConsumption: String
)
