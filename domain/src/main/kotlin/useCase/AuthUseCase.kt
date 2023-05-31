package useCase

import model.auth.AccessTokenResponse
import model.auth.Auth
import repository.AuthRepository
import util.ResultStatus

class AuthUseCase (private val authRepository: AuthRepository) {
    suspend operator fun invoke(auth: Auth): ResultStatus<AccessTokenResponse>{
        return authRepository.auth(auth)
    }
}