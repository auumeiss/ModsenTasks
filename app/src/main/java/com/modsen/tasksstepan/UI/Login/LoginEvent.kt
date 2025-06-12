package com.modsen.tasksstepan.UI.Login

import com.modsen.tasksstepan.Domain.Profile.Model.ProfileDomainModel

sealed interface LoginEvent {
    data class AuthorizationMessage(val message:String):LoginEvent
    object NavigeteToNextScreen:LoginEvent
}