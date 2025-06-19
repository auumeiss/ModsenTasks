package com.modsen.tasksstepan.Utils

sealed class TResult<out T, out E> {
    data class Success<out T>(val data:T):TResult<T,Nothing>()
    data class Error<out E>(val error: E):TResult<Nothing,E>()
}