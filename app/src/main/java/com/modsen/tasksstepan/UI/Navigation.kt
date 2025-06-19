package com.modsen.tasksstepan.UI

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.modsen.tasksstepan.UI.Login.EmptyAuthScreen
import com.modsen.tasksstepan.UI.Login.LoginScreen
import com.modsen.tasksstepan.UI.Posts.PostsScreen
import com.modsen.tasksstepan.UI.Tasks.TasksListScreen

@Composable
fun AppNav(){
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination="tasks"
    ){
        composable("posts"){
            PostsScreen()
        }
        composable("emptyScreen")
        {
            EmptyAuthScreen()
        }
        composable("tasks"){
            TasksListScreen(
                onNavigate = { task ->
                    when {
                        task.id == 1 && task.title == "Задание 1" -> navController.navigate("login")
                        task.id == 2 && task.title == "Задание 2" -> navController.navigate("posts")
                        else -> navController.navigate("emptyScreen")
                    }
                }
            )
        }
        composable("login"){
            LoginScreen (onNavigate = {navController.navigate("emptyScreen")}
            )
        }
    }
}