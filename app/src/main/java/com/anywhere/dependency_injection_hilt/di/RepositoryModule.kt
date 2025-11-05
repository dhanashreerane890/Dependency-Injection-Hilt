package com.anywhere.dependency_injection_hilt.di

import com.anywhere.dependency_injection_hilt.data.remote.repo.ProductRepositoryImpl
import com.anywhere.dependency_injection_hilt.domain.repo.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository
}