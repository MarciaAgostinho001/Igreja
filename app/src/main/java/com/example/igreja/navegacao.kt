package com.example.igreja

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.*
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController

@Composable
fun Navegacao() {

    val navController= rememberNavController()



    NavHost(navController=navController, startDestination = "Main"){
        composable("Main"){
            MainScreen(navController)
        }
        composable("Login"){
            LoginScreen()
        }
        composable("Cadastrar"){
            CadastrarScreen()
        }


    }





}

@Composable
fun MainScreen(navController: NavHostController) {

}
