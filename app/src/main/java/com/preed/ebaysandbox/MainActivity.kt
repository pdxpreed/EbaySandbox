package com.preed.ebaysandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.preed.ebaysandbox.list.CountryListViewModel
import com.preed.ebaysandbox.model.Country
import com.preed.ebaysandbox.ui.theme.EbaySandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EbaySandboxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryList(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CountryList(modifier: Modifier = Modifier, countryListViewModel: CountryListViewModel = viewModel()) {
    val countries = countryListViewModel.countries.collectAsState().value
    LazyColumn {
        items(countries) {
            CountryItem(it)
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Text(text = country.name)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EbaySandboxTheme {
//        CountryItem(
//            Country(
//                "United Kingdom"
//            )
//        )
    }
}