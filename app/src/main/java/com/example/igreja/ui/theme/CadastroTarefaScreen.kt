package com.example.igreja.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun CadastroTarefaScreen(navController: NavHostController) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var dataVencimento by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Cadastro de Tarefa", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Título
        TextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Descrição
        TextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Data de Vencimento
        TextField(
            value = dataVencimento,
            onValueChange = { dataVencimento = it },
            label = { Text("Data de Vencimento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botões de Ação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botão Cancelar
            Button(onClick = { navController.navigate("home") }) {
                Text(text = "Cancelar")
            }

            // Botão Salvar
            Button(onClick = {
                if (titulo.isNotEmpty() && descricao.isNotEmpty() && dataVencimento.isNotEmpty()) {
                    // Aqui você pode adicionar a lógica para salvar a tarefa (Room ou API)
                    navController.navigate("home")
                }
            }) {
                Text(text = "Salvar")
            }
        }
    }
}