package com.horux.convoauthenticator.mvc.services

import com.horux.convoauthenticator.mvc.models.UserDao
import com.horux.convoauthenticator.mvc.repositories.TempPasswordRepository
import com.horux.convoauthenticator.mvc.repositories.UserRepository
import com.horux.convoauthenticator.security.hashing.HashingService
import com.horux.convoauthenticator.security.hashing.SaltedHash
import com.horux.convoauthenticator.utils.exceptions.PasswordExceptions
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PasswordService(
    private val userService: UserService,
    private val tempPasswordService: TempPasswordService,
    private val hashingService: HashingService
) {

    suspend fun updatePassword(id: UUID, oldPassword: String, newPassword: String): UserDao {
        val user = userService.findById(id.toString())
        user.takeIf {
            hashingService.verifyHash(
                oldPassword,
                SaltedHash(it.salt, it.hashedPassword)
            )
        } ?: throw PasswordExceptions.IncorrectPasswordException()
        with(hashingService.generateSaltedHash(newPassword)) {
            println(user.toString())
            return userService.update(user.copy(hashedPassword = hash, salt = salt))
        }
    }

    suspend fun setOneTimePassword(username: String) = with(userService.findByUsername(username)) {
        Pair(this,tempPasswordService.setTempPassword(id))
    }

}