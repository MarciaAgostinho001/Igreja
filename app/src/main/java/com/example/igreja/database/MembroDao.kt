package com.example.igreja.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MembroDao {
    @Insert
    suspend fun inserir(membro: Membro)

    @Query("SELECT * FROM membros WHERE email = :email AND senha = :senha")
    suspend fun buscarPorEmailESenha(email: String, senha: String): Membro?

    @Query("SELECT * FROM membros")
    fun listarTodos(): Flow<List<Membro>>
}