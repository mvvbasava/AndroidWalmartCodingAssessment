package com.example.androidwalmartcodingassessment.view

import android.graphics.Color
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidwalmartcodingassessment.databinding.ActivityMainBinding
import com.example.androidwalmartcodingassessment.model.CountryListDetailsModel
import com.example.androidwalmartcodingassessment.viewModel.CountryViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countryViewModel: CountryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeLiveData()

        binding.headerText.setTextColor(Color.rgb(78, 58, 141))

        binding.getDataButton.setOnClickListener {
            fetchCountryListFromApi()
        }
    }

    private fun observeLiveData() {
        countryViewModel.countryData.observe(this) { countryListDetailsModel ->
            countryListDetailsModel?.let {
                updateUI(it)
            }
        }
    }

    internal fun fetchCountryListFromApi() {
        lifecycleScope.launch {
            countryViewModel.fetchCountryList()
        }
    }

    internal fun updateUI(countryListDetailsModel: CountryListDetailsModel) {
        countryListDetailsModel.countries.let {countryListDetailsModelList ->
            val mAdapter = CountriesAdapter(entries = countryListDetailsModelList)
            binding.countryList.apply {
                visibility = VISIBLE
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}