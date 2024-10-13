package com.horux.convoauthenticator.security.hashing

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class SHA256HashingService: HashingService {

    override fun generateSaltedHash(value: String, saltLength: Int): SaltedHash {

        val salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLength)
        val saltAsHex = Hex.encodeHexString(salt)
        val hash = DigestUtils.sha256Hex(saltAsHex + value)
        return SaltedHash(saltAsHex,hash)
    }

    override fun verifyHash(value: String, saltedHash: SaltedHash): Boolean {
        return DigestUtils.sha256Hex(saltedHash.salt + value) == saltedHash.hash
    }

}