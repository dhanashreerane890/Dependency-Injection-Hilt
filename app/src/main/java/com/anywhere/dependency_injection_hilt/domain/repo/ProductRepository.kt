package com.anywhere.dependency_injection_hilt.domain.repo

import com.anywhere.dependency_injection_hilt.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<List<Product>>
    suspend fun refreshProducts()
}