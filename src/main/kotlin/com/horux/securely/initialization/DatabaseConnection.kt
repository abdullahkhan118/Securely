package com.horux.convoauthenticator.initialization

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate

@Configuration
class DatabaseConnection {

    @Bean
    fun connectionFactory() = ConnectionFactoryBuilder.withUrl(
        "r2dbc:mysql://localhost:3306/convo_authentication?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
    ).username("user").password("abdullah").build()

    @Bean
    fun r2dbcTemplate(connectionFactory: ConnectionFactory) = R2dbcEntityTemplate(connectionFactory)

}