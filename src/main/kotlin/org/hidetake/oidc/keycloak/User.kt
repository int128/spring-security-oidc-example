package org.hidetake.oidc.keycloak

data class User(
    val id: String,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String
)
