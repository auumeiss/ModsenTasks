package com.modsen.tasksstepan.UI.Tasks

import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel

data class TasksListState(
    val isLoading: Boolean = false,
    val tasks: List<TaskDomainModel> = emptyList()
)
