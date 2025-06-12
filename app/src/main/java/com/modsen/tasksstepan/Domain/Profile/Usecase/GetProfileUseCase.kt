package com.modsen.tasksstepan.Domain.Profile.Usecase

import com.modsen.tasksstepan.Domain.Profile.Model.ProfileDomainModel
import com.modsen.tasksstepan.Domain.Profile.Repository.ProfileRepository
import com.modsen.tasksstepan.UI.Login.LoginIntent

class GetProfileUseCase (private val repository:ProfileRepository){
    suspend operator fun invoke(login: String, password:String):Result<Unit>{
        return repository.getProfile(login, password)
    }
}