package com.example.igreja

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Button as Button1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Navegacao(navController)
        }
    }
}

@Composable
fun Navegacao(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }

        composable("cadastrar") { CadastrarScreen(navController) }

        composable("login") { LoginScreen(navController) }

        composable("home") { HomeScreen(navController) }

        composable("cadastroTarefa") { CadastroTarefaScreen(navController) }

        composable("busca") { BuscaScreen(navController) }
    }
}



@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate("cadastrar")
        }, 3000)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    val name = remember { mutableStateOf("") }
    val Senha = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tela de Login")
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Usuário") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = Senha.value,
            onValueChange = { Senha.value = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button1(onClick = {   navController.navigate("home")


    }) {
            Text(text = "Login")
        }
    }
}

@Composable
fun CadastrarScreen(navController: NavController) {
    // Variáveis de estado para armazenar os valores dos campos de texto
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tela de Cadastro Membros")

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para Nome
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para E-mail
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para Senha
        TextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )
// Botão de cadastro de membros
        Spacer(modifier = Modifier.height(16.dp))
        Button1(onClick = {
            navController.navigate("login")
        }) {
            Text(text = "Cadastrar membros")
        }
        // Quando  der o click no cadastrar ele vai guardar as informações para fazer o login



    }
}

@Composable
fun HomeScreen(navController: NavController) {
    val tarefas = listOf("Reunião", "Limpeza", "Evento Especial")
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Lista de Tarefas", fontSize = 24.sp)
        LazyColumn {
            items(tarefas) { tarefa ->
                Text(tarefa, fontSize = 18.sp, modifier = Modifier.padding(8.dp))
            }

        }
    }
}

@Composable
fun CadastroTarefaScreen(navController: NavController) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var dataVencimento by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cadastro de Tarefa", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Título
        TextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título da Tarefa") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Descrição
        TextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição da Tarefa") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Data de Vencimento
        TextField(
            value = dataVencimento,
            onValueChange = { dataVencimento = it },
            label = { Text("Data de Vencimento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botões de Ação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botão Cancelar
            Button1(onClick = {
                navController.navigate("home") // Voltar para a Home
            }) {
                Text("Cancelar")
            }

            // Botão Salvar
            Button1(onClick = {
                // Aqui pode ser implementado o código para salvar a tarefa na API ou Banco de Dados
                navController.navigate("home") // Voltar para a Home após salvar
            }) {
                Text("Salvar")
            }

            }
        }
    }



@Composable
fun BuscaScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Buscar Tarefas", fontSize = 24.sp)
    }
}


