package com.anywhere.dependency_injection_hilt.di

import com.anywhere.dependency_injection_hilt.data.remote.api.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module // provides dependencies manually.
@InstallIn(SingletonComponent::class) //how long your provided dependencies will live
object NetworkModule {

    @Provides // tells hilt how to create a dependency manually.
    @Singleton // ensures a single instance throughout the app's lifecycle.
    fun provideProductApiService(): ProductApiService {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiService::class.java)
    }
}