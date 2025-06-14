package com.modsen.tasksstepan.UI.Tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TasksListScreen(
    viewModel: TasksListViewModel = koinViewModel(),
    onNavigate: (TaskDomainModel) -> Unit
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(TasksListIntent.LoadTasks)
        viewModel.event.collect { event ->
            when (event) {
                is TasksListEvent.NavigateToTask -> onNavigate(event.task)
            }
        }
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (state.isLoading)
            {
                CircularProgressIndicator()
            } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                items(state.tasks) { task: TaskDomainModel ->
                    Button(
                        onClick = { viewModel.onIntent(TasksListIntent.ClickTask(task)) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = task.title)
                    }
                }
            }
        }
    }
}
