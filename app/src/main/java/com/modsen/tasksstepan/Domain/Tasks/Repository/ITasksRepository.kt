package com.modsen.tasksstepan.Domain.Tasks.Repository

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel

interface ITasksRepository {
    suspend fun getTasks(): List<TaskDataModel>
}
