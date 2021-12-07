package com.quanle.weatherapp.domain.usercase.get_weather


import com.quanle.weatherapp.common.Resource
import com.quanle.weatherapp.data.remote.dto.toWeather
import com.quanle.weatherapp.domain.model.Weather
import com.quanle.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherUserCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(searchQuery: String): Flow<Resource<List<Weather>>> = flow {
        try {
            emit(Resource.Loading<List<Weather>>())
            val weatherList = repository.getWeathers(searchQuery).list.map { it.toWeather() }
            emit(Resource.Success<List<Weather>>(data = weatherList))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Weather>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Weather>>("Couldn't reach server. Check your internet connection."))
        }
    }
}