package com.modsen.tasksstepan.UI.Tasks

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel

interface TasksListEvent {
    data class NavigateToTask(val task: TaskDataModel) : TasksListEvent
}