package com.horux.convoauthenticator.mvc.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public/api/v1/login")
class LoginController {

    @PostMapping("/password")
    fun viaPassword() {

    }

    @PostMapping("/phone/otp")
    fun viaPhoneOtp() {

    }

    @PostMapping("/email/otp")
    fun viaEmailOtp() {

    }

    @PostMapping("/oauth")
    fun viaOAuth() {

    }

    @PostMapping("/email/link")
    fun viaEmailLink() {

    }

}