package com.anywhere.dependency_injection_hilt.di

import com.anywhere.dependency_injection_hilt.data.remote.repo.ProductRepositoryImpl
import com.anywhere.dependency_injection_hilt.domain.repo.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    // manually created repo instance and provided to hilt
    /* @Provides
     @Singleton
     fun provideProductRepository(api: ProductApiService,dao: ProductDao): ProductRepository {
         return ProductRepositoryImpl(api,dao)
     }*/

    //Auto provided repo instance by hilt
    @Provides
    @Singleton
    fun provideProductRepo(productRepositoryImpl: ProductRepositoryImpl): ProductRepository {
        return productRepositoryImpl
    }


}