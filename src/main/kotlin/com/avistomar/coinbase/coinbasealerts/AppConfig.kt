package com.avistomar.coinbase.coinbasealerts

import com.coinbase.exchange.api.accounts.AccountService
import com.coinbase.exchange.api.exchange.CoinbaseExchange
import com.coinbase.exchange.api.exchange.CoinbaseExchangeImpl
import com.coinbase.exchange.api.orders.OrderService
import com.coinbase.exchange.security.Signature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().registerModule(JavaTimeModule())
    }

    @Bean
    fun signature(): Signature {
        return Signature("M1H4Mi4GvW+FC8nYFibnJyvmElaOAoD6FHM7L4iaoLycxTk4/8l4GEuxPubLO2k8JRTPcUfIuXzqY8lbDnYtFg==")
    }

    @Bean
    fun coinbasePro(signature: Signature, objectMapper: ObjectMapper): CoinbaseExchange {
        return CoinbaseExchangeImpl(
            "21ac276d66516a60576fb1a2ff12de48",
            "1q7yigr3l9w",
            "https://api-public.sandbox.pro.coinbase.com/",
            signature,
            objectMapper
        )
    }

    @Bean
    fun accountService(exchange: CoinbaseExchange): AccountService {
        return AccountService(exchange)
    }

    @Bean
    fun orderService(exchange: CoinbaseExchange): OrderService {
        return OrderService(exchange)
    }
}