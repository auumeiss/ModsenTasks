package com.modsen.tasksstepan

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.modsen.tasksstepan.DI.loginModule
import com.modsen.tasksstepan.DI.tasksModule
import com.modsen.tasksstepan.UI.Login.LoginScreen
import com.modsen.tasksstepan.UI.Tasks.TasksListScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.KoinConfiguration
import org.koin.dsl.koinConfiguration

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                tasksModule,
                loginModule
            )
        }
    }
}

@Composable
fun AppNav(){
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination="tasks"
    ){
        composable("tasks"){
            TasksListScreen (onNavigate = {navController.navigate("login")}
            )
        }
        composable("login"){
            LoginScreen ()
        }
    }
}