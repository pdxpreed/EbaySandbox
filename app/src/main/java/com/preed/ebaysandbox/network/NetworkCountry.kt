package com.preed.ebaysandbox.network

data class NetworkCountry(
    val name: NetworkCountryName,
    val capital: List<String>,
    val currencies: NetworkCountryCurrency
)

data class NetworkCountryName(
    val common: String
)

data class NetworkCountryCurrency(
    val currencies: Map<String, NetworkCurrency>?
)

data class NetworkCurrency(
    val name: String,
    val symbol: String
)