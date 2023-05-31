package model.auth

data class AccessTokenResponse (
    val access_token: String,
    val token_type: String,
    val expires_in: Long,
    val refresh_token: String,
    val scope: String,
    val created_at: Long
    )