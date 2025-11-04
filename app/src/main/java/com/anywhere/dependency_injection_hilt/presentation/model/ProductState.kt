package com.anywhere.dependency_injection_hilt.presentation.model

import com.anywhere.dependency_injection_hilt.domain.model.Product

data class ProductState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)