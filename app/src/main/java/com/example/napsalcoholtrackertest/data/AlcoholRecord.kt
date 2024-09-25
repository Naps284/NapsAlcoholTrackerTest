package com.example.napsalcoholtrackertest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alcohol_record")
data class AlcoholRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val concentration: Float,
    val volume: Float,
    val timeOfConsumption: String // You can change this to a Date or other format as needed
)
