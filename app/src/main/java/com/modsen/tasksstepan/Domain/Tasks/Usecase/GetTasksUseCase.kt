package com.modsen.tasksstepan.Domain.Tasks.Usecase

import com.modsen.tasksstepan.Data.Tasks.Model.TaskDataModel
import com.modsen.tasksstepan.Domain.Tasks.Repository.ITasksRepository

class GetTasksUseCase(private val repository: ITasksRepository) {
    suspend operator fun invoke(): List<TaskDataModel> {
        return repository.getTasks()
    }
}
