package com.modsen.tasksstepan.DI

import com.modsen.tasksstepan.Data.Tasks.Repository.TasksRepositoryImpl
import com.modsen.tasksstepan.Domain.Tasks.Repository.TasksRepository
import com.modsen.tasksstepan.Domain.Tasks.Usecase.GetTasksUseCase
import com.modsen.tasksstepan.UI.Tasks.TasksListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tasksModule = module {

    single<TasksRepository> { TasksRepositoryImpl() }

    factory { GetTasksUseCase(get()) }

    viewModel { TasksListViewModel(get()) }
}