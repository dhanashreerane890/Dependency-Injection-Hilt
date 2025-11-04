package com.anywhere.dependency_injection_hilt.domain.usecase

import com.anywhere.dependency_injection_hilt.domain.model.Product
import com.anywhere.dependency_injection_hilt.domain.repo.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    fun execute(): Flow<List<Product>> = repository.getProducts()
}