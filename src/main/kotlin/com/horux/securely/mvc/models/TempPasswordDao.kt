package com.horux.convoauthenticator.mvc.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("temp_password")
data class TempPasswordDao(
    @Id
    @Column("user_id")
    var userId: String,
    @Column("hashed_password")
    val tempPassword: String,
    val salt: String,
)
