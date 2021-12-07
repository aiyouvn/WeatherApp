package com.quanle.weatherapp.domain.repository

import com.quanle.weatherapp.data.remote.dto.WeatherDto

interface WeatherRepository {
    suspend fun getWeathers(param : String): WeatherDto
}