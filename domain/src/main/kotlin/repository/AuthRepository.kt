package repository

import model.auth.AccessTokenResponse
import model.auth.Auth
import util.ResultStatus

interface AuthRepository {

    suspend fun auth(auth: Auth): ResultStatus<AccessTokenResponse>
}