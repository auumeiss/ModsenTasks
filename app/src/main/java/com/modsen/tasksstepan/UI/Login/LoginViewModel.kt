package com.modsen.tasksstepan.UI.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modsen.tasksstepan.Domain.Profile.Usecase.GetProfileUseCase
import com.modsen.tasksstepan.UI.Common.SingleFlowEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel (private val getProfileUseCase:GetProfileUseCase) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    private val _event= SingleFlowEvent<LoginEvent>(viewModelScope)
    val event=_event.flow

    fun onIntent(intent:LoginIntent) {
        when (intent) {
            is LoginIntent.EnterUsername -> {
                _state.update {it.copy(login=intent.login)}
            }
            is LoginIntent.EnterPassword->{
            _state.update{it.copy(password=intent.password)}
            }
            is LoginIntent.Submit->{
                submit()
            }
        }
        }
    private fun submit(){
        val username= _state.value.login
        val password=_state.value.password

        viewModelScope.launch {
            _state.update{it.copy(isLoading=true)}
            delay(1000)
            val result=getProfileUseCase(username,password)
            _state.update{it.copy(isLoading = false)}
            result.fold(
                onSuccess = {_event.emit(LoginEvent.AuthorizationMessage("Логин и пароль верны"))},
                onFailure = {_event.emit(LoginEvent.AuthorizationMessage("Неверный логин или пароль"))}
            )
        }
    }

}

