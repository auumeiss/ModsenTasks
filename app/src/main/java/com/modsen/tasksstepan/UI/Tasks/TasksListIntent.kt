package com.modsen.tasksstepan.UI.Tasks

import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel

interface TasksListIntent {
    object LoadTasks : TasksListIntent
    data class ClickTask(val task: TaskDomainModel) : TasksListIntent
}
