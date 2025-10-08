package com.example.androidwalmartcodingassessment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidwalmartcodingassessment.converters.convertToCountryDetailsModel
import com.example.androidwalmartcodingassessment.model.CountryListDetailsModel
import com.example.androidwalmartcodingassessment.network.CountryRetrofitClient

class CountryViewModel : ViewModel() {
    private val _countryData = MutableLiveData<CountryListDetailsModel?>()
    val countryData: LiveData<CountryListDetailsModel?> = _countryData
    suspend fun fetchCountryList() {
        try {
            val response = CountryRetrofitClient.apiService.getCountryList()
            _countryData.postValue(response.convertToCountryDetailsModel())
        } catch (exception: Exception) {
            // "Failed to load countries: ${e.message}"
            _countryData.postValue(null)
        }
    }
}