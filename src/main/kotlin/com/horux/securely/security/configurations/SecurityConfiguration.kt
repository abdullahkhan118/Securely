package com.horux.convoauthenticator.security.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfiguration {

    init {
        println("SecurityConfig loaded")
    }

    @Bean
    fun publicSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain = http
        .csrf {
            it.disable()
        }
        .anonymous {
            it.disable()
        }
        .authorizeExchange {
            it.pathMatchers("/api/v1/public/**").permitAll()
            it.anyExchange().authenticated()
        }
        .formLogin {
            it.disable()
        }
        .build()

}