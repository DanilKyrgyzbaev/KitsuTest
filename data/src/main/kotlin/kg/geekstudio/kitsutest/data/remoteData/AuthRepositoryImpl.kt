package kg.geekstudio.kitsutest.data.remoteData

import kg.geekstudio.kitsutest.data.apiservices.AuthApiService
import model.auth.AccessTokenResponse
import model.auth.Auth
import repository.AuthRepository
import util.ResultStatus

class AuthRepositoryImpl(private val authApiService: AuthApiService): AuthRepository {
    override suspend fun auth(auth: Auth): ResultStatus<AccessTokenResponse>{
        return try {
            val response = authApiService.authenticate((auth))
            if (response.isSuccessful){
                val authResponse = response.body()
                authResponse?.let {
                    ResultStatus.Success(it)
                }?:ResultStatus.Error(null, "${response.errorBody()}")
            } else{
                ResultStatus.Error(null, "${response.errorBody()}")
            }
        } catch (e: Exception){
            ResultStatus.Error(null, e.message)
        }
    }
}