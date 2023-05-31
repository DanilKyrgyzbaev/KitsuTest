package model.auth

data class Auth(
    val grant_type: String,
    val username: String,
    val password: String,
)
