package com.modsen.tasksstepan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.modsen.tasksstepan.UI.Tasks.TasksListScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasksListScreen(
                viewModel = koinViewModel(),
                onNavigate = { task ->
                    // Здесь реализуйте логику навигации, например открыть детали задачи
                }
            )
        }
    }
}