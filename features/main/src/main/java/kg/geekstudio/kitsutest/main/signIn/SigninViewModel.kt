package kg.geekstudio.kitsutest.main.signIn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import kg.geekstudio.kitsutest.data.local.TokenPreferences
import kotlinx.coroutines.launch
import model.auth.AccessTokenResponse
import model.auth.Auth
import state.UIState
import useCase.AuthUseCase
import util.ResultStatus

class SigninViewModel(private val authUseCase: AuthUseCase) : BaseViewModel() {
    private val _token = MutableLiveData<UIState<AccessTokenResponse>>()
    val token: LiveData<UIState<AccessTokenResponse>> = _token

    fun auth(auth: Auth){
        viewModelScope.launch {
            val result = authUseCase.invoke(auth)
            when (result){
                is ResultStatus.Success -> {
                    Log.e("Response", "${result.data}")
                    TokenPreferences.userAccessToken = result.data!!.access_token
                    TokenPreferences.userRefreshToken = result.data!!.refresh_token
                    _token.value = UIState.Success(result.data!!)
                }
                is ResultStatus.Error -> {

                    _token.value = UIState.Error(result.message ?: "")
                    Log.e("Error", "${result.message}")
                }
                is ResultStatus.Loading ->{

                }
            }
        }
    }
}