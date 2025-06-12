package com.modsen.tasksstepan.Domain.Profile.Repository

import com.modsen.tasksstepan.Domain.Profile.Model.ProfileDomainModel
import com.modsen.tasksstepan.Domain.Tasks.Model.TaskDomainModel

interface ProfileRepository {
    suspend fun getProfile(login: String, password:String):Result<Unit>
}
