package com.preed.ebaysandbox.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RetrofitRemoteCountryGateway : RemoteCountryGateway {
    private val retrofitService =
        Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/region/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NorthernEuropeCountryService::class.java)

    override suspend fun getCountriesInRegion(region: String): List<NetworkCountry> {
        return retrofitService.getCountries(region)
    }
}

private interface NorthernEuropeCountryService {
    @GET("{region}")
    suspend fun getCountries(@Path("region") region: String): List<NetworkCountry>
}

sealed class CountryNetworkResult {

}