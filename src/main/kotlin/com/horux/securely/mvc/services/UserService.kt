package com.horux.convoauthenticator.mvc.services

import com.horux.convoauthenticator.mvc.models.UserDao
import com.horux.convoauthenticator.mvc.repositories.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    suspend fun findById(id: String): UserDao = repository.findById(id) ?: throw NotFoundException()
    suspend fun update(userDao: UserDao): UserDao = repository.save(userDao)
    suspend fun findByUsername(username: String): UserDao = repository.findByUsername(username) ?: throw NotFoundException()

}