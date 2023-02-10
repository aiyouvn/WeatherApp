package com.quanle.weatherapp.di


import com.quanle.weatherapp.common.Constants
import com.quanle.weatherapp.data.remote.WeatherApi
import com.quanle.weatherapp.data.repository.WeatherRepositoryImpl
import com.quanle.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(interceptor: HttpLoggingInterceptor): WeatherApi {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.addInterceptor(interceptor)
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}