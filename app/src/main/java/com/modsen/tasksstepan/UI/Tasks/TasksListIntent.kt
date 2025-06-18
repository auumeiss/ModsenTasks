package com.modsen.tasksstepan.UI.Tasks

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel

interface TasksListIntent {
    object LoadTasks : TasksListIntent
    data class ClickTask(val task: TaskDataModel) : TasksListIntent
}
