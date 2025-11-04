package com.anywhere.dependency_injection_hilt.data.remote.model

data class ProductsResponse(
    val products: List<ProductDto>
)

data class ProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val category: String
)