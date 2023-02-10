package com.quanle.weatherapp.data.repository

import com.quanle.weatherapp.data.remote.WeatherApi
import com.quanle.weatherapp.data.remote.dto.GetWeatherParam
import com.quanle.weatherapp.data.remote.dto.WeatherDto
import com.quanle.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getWeathers(param:String): WeatherDto {
        return weatherApi.getWeathers(param)
    }
}