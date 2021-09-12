package com.avistomar.coinbase.coinbasealerts

import com.coinbase.exchange.api.accounts.AccountService
import com.coinbase.exchange.api.orders.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val accountService: AccountService,
    private val orderService: OrderService
) {

    @GetMapping("/hello")
    fun hello(): String {
        return "Voila, it works!"
    }

    @PostMapping("/create-order")
    fun createOrder(@RequestBody priceAlert: PriceAlert) {

    }
}