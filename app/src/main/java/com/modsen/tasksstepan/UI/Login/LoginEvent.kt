package com.modsen.tasksstepan.UI.Login

sealed interface LoginEvent {
    data class AuthorizationMessage(val message:String):LoginEvent
    object NavigeteToNextScreen:LoginEvent
}