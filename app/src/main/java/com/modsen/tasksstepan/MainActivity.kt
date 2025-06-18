package com.modsen.tasksstepan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import com.modsen.tasksstepan.UI.AppNav
import com.modsen.tasksstepan.UI.Tasks.TasksListScreen
import com.modsen.tasksstepan.UI.ui.theme.ModsenTasksStepanTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModsenTasksStepanTheme {
                AppNav()
            }
        }
    }
}