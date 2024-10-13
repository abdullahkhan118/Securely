package com.horux.convoauthenticator.mvc.services

import com.horux.convoauthenticator.mvc.models.UserDao
import com.horux.convoauthenticator.mvc.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class LoginService(
    val userRepository: UserRepository,
) {

}