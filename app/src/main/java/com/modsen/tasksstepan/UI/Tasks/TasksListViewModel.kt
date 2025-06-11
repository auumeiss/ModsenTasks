package com.modsen.tasksstepan.UI.Tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modsen.tasksstepan.Domain.Tasks.Usecase.GetTasksUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SingleFlowEvent<T>(private val scope: CoroutineScope) {
    private val channel = Channel<T>(Channel.UNLIMITED)
    val flow = channel.receiveAsFlow().shareIn(scope, SharingStarted.WhileSubscribed(), 0)

    fun emit(value: T) {
        scope.launch {
            channel.send(value)
        }
    }
}


class TasksListViewModel(
    private val getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TasksListState())
    val state: StateFlow<TasksListState> = _state

    private val _event = SingleFlowEvent<TasksListEvent>(viewModelScope)
    val event = _event.flow

    fun onIntent(intent: TasksListIntent) {
        when (intent) {
            is TasksListIntent.LoadTasks -> loadTasks()
            is TasksListIntent.ClickTask -> _event.emit(TasksListEvent.NavigateToTask(intent.task))
        }
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val tasks = getTasksUseCase()
            _state.update { it.copy(tasks = tasks, isLoading = false) }
        }
    }
}