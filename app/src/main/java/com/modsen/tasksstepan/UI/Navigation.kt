package com.modsen.tasksstepan.UI

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.modsen.tasksstepan.UI.Login.EmptyAuthScreen
import com.modsen.tasksstepan.UI.Login.LoginScreen
import com.modsen.tasksstepan.UI.Tasks.TasksListScreen

@Composable
fun AppNav(){
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination="tasks"
    ){
        composable("emptyScreen")
        {
            EmptyAuthScreen()
        }
        composable("tasks"){
            TasksListScreen (onNavigate = {navController.navigate("login")}
            )
        }
        composable("login"){
            LoginScreen (onNavigate = {navController.navigate("emptyScreen")}
            )
        }
    }
}