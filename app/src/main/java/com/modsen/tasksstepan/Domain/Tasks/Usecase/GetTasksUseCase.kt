package com.modsen.tasksstepan.Domain.Tasks.Usecase

import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel
import com.modsen.tasksstepan.Domain.Tasks.Repository.TasksRepository

class GetTasksUseCase(private val repository: TasksRepository) {
    suspend operator fun invoke(): List<TaskDomainModel> {
        return repository.getTasks()
    }
}
