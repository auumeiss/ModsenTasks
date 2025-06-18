package com.modsen.tasksstepan.Domain.Profile.Repository

interface IProfileRepository {
    suspend fun getProfile(login: String, password:String):Result<Unit>
}
