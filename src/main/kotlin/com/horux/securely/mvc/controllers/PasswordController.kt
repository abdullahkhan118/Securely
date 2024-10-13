package com.horux.convoauthenticator.mvc.controllers

import com.horux.convoauthenticator.mvc.requests.PasswordUpdateRequest
import com.horux.convoauthenticator.mvc.requests.TempPasswordRequest
import com.horux.convoauthenticator.mvc.services.PasswordService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/public/password")
class PasswordController(
    private val service: PasswordService
) {

    @PostMapping("/update")
    suspend fun update(@RequestBody request: PasswordUpdateRequest) =
        service.updatePassword(request.id, request.oldPassword, request.newPassword)

    // viaEmail or phone (One time use only)
    @PostMapping("/forgot")
    suspend fun forgot(@RequestBody request: TempPasswordRequest): String {
        val (user,password) = service.setOneTimePassword(request.username)
        return "A temporary password has been sent to ${user.email} temp password: $password"
    }

}