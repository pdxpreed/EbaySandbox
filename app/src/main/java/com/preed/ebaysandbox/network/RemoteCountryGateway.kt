package com.preed.ebaysandbox.network

interface RemoteCountryGateway {
    suspend fun getCountriesInRegion(region: String): List<NetworkCountry>
}