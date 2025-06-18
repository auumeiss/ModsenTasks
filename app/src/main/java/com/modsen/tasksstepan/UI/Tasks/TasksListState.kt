package com.modsen.tasksstepan.UI.Tasks

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel

data class TasksListState(
    val isLoading: Boolean = false,
    val tasks: List<TaskDataModel> = emptyList()
)
