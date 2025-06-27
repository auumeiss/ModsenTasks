package com.modsen.tasksstepan.Data.Tasks.Repository

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel
import com.modsen.tasksstepan.Domain.Tasks.Repository.ITasksRepository

class TasksRepositoryImpl : ITasksRepository {

    private val tasks = listOf(
        TaskDataModel(1, "Задание 1"), TaskDataModel(2, "Задание 2")
    )

    override suspend fun getTasks(): List<TaskDataModel> {
        return tasks.map { it}
    }
}
