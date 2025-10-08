package com.example.androidwalmartcodingassessment.model

import android.os.Parcelable
import com.example.androidwalmartcodingassessment.model.CountryDetailsModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryListDetailsModel(
    var countries  : List<CountryDetailsModel>
) : Parcelable