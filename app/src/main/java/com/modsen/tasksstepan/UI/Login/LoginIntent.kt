package com.modsen.tasksstepan.UI.Login

interface LoginIntent {
    class EnterUsername(val login:String):LoginIntent
    class EnterPassword(val password:String):LoginIntent
    object Submit: LoginIntent
}