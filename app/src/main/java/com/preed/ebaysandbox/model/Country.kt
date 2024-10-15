package com.preed.ebaysandbox.model

data class Country(
    val name: String,
    val capital: List<String>,
    val currencies: List<String>?
)