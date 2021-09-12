package com.avistomar.coinbase.coinbasealerts

data class PriceAlert(
    val type: String,
    val message: String,
    val currency: String,
    val direction: String,
    val price: String,
    var targetCurrency: String,
    val exchange: String
)