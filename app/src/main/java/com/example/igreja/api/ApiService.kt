package com.example.igreja.api


import com.example.igreja.database.Membro
import com.example.igreja.database.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("membros/cadastrar")
    suspend fun cadastrarMembro(@Body membro: Membro): Response<Membro>

    @POST("tarefas/cadastrar")
    suspend fun cadastrarTarefa(@Body tarefa: Tarefa): Response<Tarefa>
}