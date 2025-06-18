package com.modsen.tasksstepan.Data.Profile.Repository

import com.modsen.tasksstepan.Data.Profile.Model.ProfileDataModel
import com.modsen.tasksstepan.Domain.Profile.Repository.IProfileRepository

class ProfileRepositoryImpl:IProfileRepository {

    private val profile = listOf(
        ProfileDataModel("stepan","stepan"),
    )
    override suspend fun getProfile(login:String, password:String): Result<Unit> {
        val profileData = profile.map{it}
        val result:Result<Unit>
        val findProfile = profileData.find { it.login==login && it.password == password }
        if (findProfile!=null){
            result=Result.success(Unit)
        } else {
            result = Result.failure(Exception("Неверный пароль/логин"))
            }
        return result
    }
}