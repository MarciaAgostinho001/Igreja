package com.example.igreja.ui.theme


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.igreja.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun LoginScreen(navController: NavHostController) {
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val context = LocalContext.current // Obter o contexto
    val db = remember { AppDatabase.getDatabase(context) } // Inicializar o banco de dados

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tela de Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de E-mail
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Senha
        TextField(
            value = senha.value,
            onValueChange = { senha.value = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de Login
        Button(
            onClick = {
                if (email.value.isEmpty() || senha.value.isEmpty()) {
                    Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                } else {
                    CoroutineScope(Dispatchers.IO).launch {
                        val membro = db.membroDao().buscarPorEmailESenha(email.value, senha.value)
                        if (membro != null) {
                            // Navegar para a tela home
                            withContext(Dispatchers.Main) {
                                navController.navigate("home")
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "E-mail ou senha incorretos!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botão para Cadastrar
        TextButton(onClick = { navController.navigate("cadastrar") }) {
            Text(text = "Não tem uma conta? Cadastre-se")
        }
    }
}