package com.quanle.weatherapp.presentation.weather_list

import com.quanle.weatherapp.domain.model.Weather

data class WeatherListState(
    val isLoading: Boolean = false,
    val weathers: List<Weather> = emptyList(),
    val error: String = ""
)
