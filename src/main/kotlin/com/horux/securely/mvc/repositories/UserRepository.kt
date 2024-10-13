package com.horux.convoauthenticator.mvc.repositories

import com.horux.convoauthenticator.mvc.models.UserDao
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository: CoroutineCrudRepository<UserDao, String> {

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun findByUsername(username: String): UserDao?

}