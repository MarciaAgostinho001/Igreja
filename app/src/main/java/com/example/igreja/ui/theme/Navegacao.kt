package com.example.igreja.ui.theme


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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