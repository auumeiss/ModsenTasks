package com.modsen.tasksstepan.UI.Tasks

import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel

interface TasksListEvent {
    data class NavigateToTask(val task: TaskDomainModel) : TasksListEvent
}