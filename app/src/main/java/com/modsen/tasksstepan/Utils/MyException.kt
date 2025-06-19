package com.modsen.tasksstepan.Utils

sealed class MyException:Throwable() {
    object NoInternet: MyException()
    data class Other(val errorMessage:String): MyException()
}

fun Throwable.toMyException(): MyException {
    return when (this){
        is java.net.UnknownHostException,
        is java.net.ConnectException-> MyException.NoInternet
        else -> MyException.Other("Other error")
    }
}