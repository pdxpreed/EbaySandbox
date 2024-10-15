package com.preed.ebaysandbox.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.preed.ebaysandbox.model.Country
import com.preed.ebaysandbox.network.RetrofitRemoteCountryGateway
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class CountryListViewModel : ViewModel() {
    val countries = flow {
        emit(
            RetrofitRemoteCountryGateway.getCountriesInRegion("Northern Europe")
                .map { networkCountry ->
                    Country(networkCountry.name.common,
                        networkCountry.capital,
                        networkCountry.currencies.currencies?.map { it.value.name })
                })
    }.stateIn(
        scope = viewModelScope,
        initialValue = emptyList(),
        started = SharingStarted.WhileSubscribed(5000)
    )

    private val _currentCountry = MutableStateFlow<Country?>(null)
    val currentCountry = _currentCountry.asStateFlow()

    fun selectCountry(country: Country?) {
        _currentCountry.value = country
    }
}