package com.modsen.tasksstepan.Data.Profile.Repository

import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.firestore
import com.modsen.tasksstepan.Data.Profile.Model.ProfileDataModel
import com.modsen.tasksstepan.Domain.Profile.Model.ProfileDomainModel
import com.modsen.tasksstepan.Domain.Profile.Repository.ProfileRepository
import kotlinx.coroutines.tasks.await

class ProfileRepositoryImpl:ProfileRepository {
    fun ProfileDataModel.toDomain()=ProfileDomainModel(login,password)

    private val profile = listOf(
        ProfileDataModel("stepan","stepan"),
    )
    override suspend fun getProfile(login:String, password:String): Result<Unit> {
        val profileDomain = profile.map{it.toDomain()}
        val result:Result<Unit>
        val findProfile = profileDomain.find { it.login==login && it.password == password }
        if (findProfile!=null){
            result=Result.success(Unit)
        } else {
            result = Result.failure(Exception("Неверный пароль/логин"))
            }
        return result
    }
}