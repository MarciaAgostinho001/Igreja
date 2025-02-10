package com.example.igreja.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TarefaDao {
    @Insert
    suspend fun inserir(tarefa: Tarefa)

    @Query("SELECT * FROM tarefas")
    fun listarTodas(): Flow<List<Tarefa>>
}