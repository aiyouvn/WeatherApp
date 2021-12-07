package com.quanle.weatherapp.presentation.weather_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quanle.weatherapp.common.Resource
import com.quanle.weatherapp.domain.usercase.get_weather.GetWeatherUserCase
import com.quanle.weatherapp.util.CacheMemory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherListViewModel @Inject constructor(
    private val getWeathersUseCase: GetWeatherUserCase
) : ViewModel() {
    private val _state = mutableStateOf(WeatherListState())
    val state: State<WeatherListState> = _state
    val query = mutableStateOf("")

    fun getWeatherList(searchQuery: String) {
        val cache = CacheMemory.cacheResult[searchQuery]
        cache?.let {
            _state.value = WeatherListState(weathers = it)
            return
        }
        getWeathersUseCase(searchQuery).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = WeatherListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = WeatherListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = WeatherListState(weathers = result.data ?: emptyList())
                    result.data?.let { data ->
                        CacheMemory.cacheResult[searchQuery] = data
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onQueryChanged(value: String) {
        this.query.value = value.trim()
    }
}