package com.example.igreja.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    val tarefas = listOf("Reunião de membro", "Aulas Batismo", "Cultos")

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Lista de Tarefas",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(tarefas) { tarefa ->
                Text(
                    text = tarefa,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Botão para Cadastrar Tarefa
        Button(
            onClick = { navController.navigate("cadastroTarefa") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Adicionar Tarefa")
        }
    }
}