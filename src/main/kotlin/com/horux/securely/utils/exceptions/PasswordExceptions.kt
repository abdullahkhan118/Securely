package com.horux.convoauthenticator.utils.exceptions

sealed class PasswordExceptions(override val message: String?): Exception(message) {

    class IncorrectPasswordException: PasswordExceptions("The provided password is incorrect")
    class InvalidFormatException: PasswordExceptions("The provided format is invalid")

}