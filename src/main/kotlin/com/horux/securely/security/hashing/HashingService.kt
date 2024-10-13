package com.horux.convoauthenticator.security.hashing

interface HashingService {

    fun generateSaltedHash(value: String,saltLength: Int = 64): SaltedHash

    fun verifyHash(value: String, saltedHash: SaltedHash): Boolean

}