package com.example.igreja.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "membros")
data class Membro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val email: String,
    val senha: String
)