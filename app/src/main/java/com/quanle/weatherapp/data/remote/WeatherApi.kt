package com.quanle.weatherapp.data.remote

import com.quanle.weatherapp.common.Constants.API_KEY
import com.quanle.weatherapp.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast/daily")
    suspend fun getWeathers(
        @Query("q")
        searchQuery: String,
        @Query("cnt")
        cnt: Int = 7,
        @Query("appid")
        appid: String = API_KEY,
        @Query("units")
        units :String = "metric"
    ): WeatherDto
}