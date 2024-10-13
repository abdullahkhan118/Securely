package com.horux.convoauthenticator.mvc.requests

import java.util.UUID

data class PasswordUpdateRequest(
    val id: UUID,
    val oldPassword: String,
    val newPassword: String
)
