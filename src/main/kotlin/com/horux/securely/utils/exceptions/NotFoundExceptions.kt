package com.horux.convoauthenticator.utils.exceptions

import java.util.UUID


sealed class NotFoundExceptions(override val message: String): Exception(message) {

    abstract val id: UUID

    class User(override val id: UUID) : NotFoundExceptions("User with id $id was not found")

}
