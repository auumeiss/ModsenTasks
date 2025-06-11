package com.modsen.tasksstepan.Domain.Tasks.Repository

import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel

interface TasksRepository {
    suspend fun getTasks(): List<TaskDomainModel>
}
