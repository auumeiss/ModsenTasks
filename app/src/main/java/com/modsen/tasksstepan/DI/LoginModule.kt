package com.modsen.tasksstepan.DI

import com.modsen.tasksstepan.Data.Profile.Repository.ProfileRepositoryImpl
import com.modsen.tasksstepan.Data.Tasks.Repository.TasksRepositoryImpl
import com.modsen.tasksstepan.Domain.Profile.Repository.ProfileRepository
import com.modsen.tasksstepan.Domain.Profile.Usecase.GetProfileUseCase
import com.modsen.tasksstepan.Domain.Tasks.Repository.TasksRepository
import com.modsen.tasksstepan.Domain.Tasks.Usecase.GetTasksUseCase
import com.modsen.tasksstepan.UI.Login.LoginViewModel
import com.modsen.tasksstepan.UI.Tasks.TasksListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single<ProfileRepository> { ProfileRepositoryImpl() }

    factory { GetProfileUseCase(get()) }

    viewModel { LoginViewModel(get()) }
}