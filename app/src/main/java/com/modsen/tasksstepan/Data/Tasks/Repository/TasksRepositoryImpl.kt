package com.modsen.tasksstepan.Data.Tasks.Repository

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel
import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel
import com.modsen.tasksstepan.Domain.Tasks.Repository.TasksRepository

class TasksRepositoryImpl : TasksRepository {
    fun TaskDataModel.toDomain() = TaskDomainModel(id, title)

    private val tasks = listOf(
        TaskDataModel(1, "Задание 1"),
    )

    override suspend fun getTasks(): List<TaskDomainModel> {
        return tasks.map { it.toDomain() }
    }
}
