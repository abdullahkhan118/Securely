package com.horux.convoauthenticator.filters

import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

//class LoggingFilter: WebFilter {
//
//    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
//        with(exchange.request) {
//            println("Request: ${toString()}")
//        }
//        with(exchange.response) {
//            println("Response: ${toString()}")
//        }
//        return chain.filter(exchange)
//    }
//
//}