package com.horux.convoauthenticator.security.hashing

data class SaltedHash(
    val salt: String,
    val hash: String
)