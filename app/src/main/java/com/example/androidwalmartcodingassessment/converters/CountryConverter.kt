package com.example.androidwalmartcodingassessment.converters

import com.example.androidwalmartcodingassessment.model.CountryDetailsModel
import com.example.androidwalmartcodingassessment.model.CountryListDetailsModel
import com.example.androidwalmartcodingassessment.model.CurrencyDetailsModel
import com.example.androidwalmartcodingassessment.model.LanguageDetailsModel
import com.example.androidwalmartcodingassessment.network.jsonData.Country

fun List<Country>.convertToCountryDetailsModel() : CountryListDetailsModel {
    val countryModelList = mutableListOf<CountryDetailsModel>()
    this.forEach { country ->
        val currencyDetailsModel = CurrencyDetailsModel(
            code = country.currency?.code,
            name = country.currency?.name,
            symbol = country.currency?.symbol,
        )
        val languageDetailsModel = LanguageDetailsModel(
            code = country.language?.code,
            name = country.language?.name
        )
        val countryDetailsModel = CountryDetailsModel(capital = country.capital,
            code = country.code,
            currency = currencyDetailsModel,
            flag = country.flag,
            language = languageDetailsModel,
            name = country.name,
            region = country.region
        )
        countryModelList.add(countryDetailsModel)
    }
    return CountryListDetailsModel(countries = countryModelList)
}