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

    override suspend fun getProfile(login:String, password:String): Result<Unit> {
        val data = Firebase.firestore.collection("users").document(login).get().await()
        val potentialPassword = data.getString("password")
        val result:Result<Unit>
        if (password==potentialPassword){
            result=Result.success(Unit)
        } else {
            result = Result.failure(Exception("Неверный пароль"))
            }
        return result
    }
}