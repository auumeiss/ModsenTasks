package com.modsen.tasksstepan.DI

import com.modsen.tasksstepan.Data.Profile.Repository.ProfileRepositoryImpl
import com.modsen.tasksstepan.Domain.Profile.Repository.IProfileRepository
import com.modsen.tasksstepan.Domain.Profile.Usecase.GetProfileUseCase
import com.modsen.tasksstepan.UI.Login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single<IProfileRepository> { ProfileRepositoryImpl() }

    factory { GetProfileUseCase(get()) }

    viewModel { LoginViewModel(get()) }
}