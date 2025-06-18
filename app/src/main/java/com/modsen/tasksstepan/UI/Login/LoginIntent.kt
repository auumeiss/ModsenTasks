package com.modsen.tasksstepan.UI.Login

sealed interface LoginIntent {
    data class EnterUsername(val login:String):LoginIntent
    data class EnterPassword(val password:String):LoginIntent
    data object Submit: LoginIntent
}