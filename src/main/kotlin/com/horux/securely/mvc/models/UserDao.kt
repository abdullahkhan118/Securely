package com.horux.convoauthenticator.mvc.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("users")
data class UserDao(
    @Id
    val id: String,
    @Column("created_at")
    val createdAt: LocalDateTime,
    val username: String,            // Corresponds to VARCHAR(50)
    val name: String,                // Corresponds to VARCHAR(50)
    val email: String,               // Corresponds to VARCHAR(100)
    @Column("hashed_password")
    val hashedPassword: String,      // Corresponds to CHAR(64)
    val salt: String                 // Corresponds to CHAR(64)
)