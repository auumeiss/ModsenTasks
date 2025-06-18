package com.modsen.tasksstepan.Domain.Profile.Usecase

import com.modsen.tasksstepan.Domain.Profile.Repository.IProfileRepository

class GetProfileUseCase (private val repository:IProfileRepository){
    suspend operator fun invoke(login: String, password:String):Result<Unit>{
        return repository.getProfile(login, password)
    }
}