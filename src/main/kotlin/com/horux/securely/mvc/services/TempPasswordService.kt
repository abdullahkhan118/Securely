package com.horux.convoauthenticator.mvc.services

import com.horux.convoauthenticator.mvc.models.TempPasswordDao
import com.horux.convoauthenticator.mvc.repositories.TempPasswordRepository
import com.horux.convoauthenticator.security.hashing.HashingService
import org.apache.commons.codec.binary.Hex
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class TempPasswordService(
    private val repository: TempPasswordRepository,
    private val hashingService: HashingService
) {

    suspend fun setTempPassword(id: String): String? {
        val randomPassword = SecureRandom.getInstance("SHA1PRNG").generateSeed(64)
        val randomPasswordAsHex = Hex.encodeHexString(randomPassword)
        val saltedHash = hashingService.generateSaltedHash(randomPasswordAsHex)
        repository.insert(TempPasswordDao(id, salt = saltedHash.salt, tempPassword = saltedHash.hash))
        return randomPasswordAsHex
    }
}