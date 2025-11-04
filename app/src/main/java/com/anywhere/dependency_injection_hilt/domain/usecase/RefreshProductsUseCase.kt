package com.anywhere.dependency_injection_hilt.domain.usecase

import com.anywhere.dependency_injection_hilt.domain.repo.ProductRepository
import javax.inject.Inject

class RefreshProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend fun execute() = repository.refreshProducts()
}