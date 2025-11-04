package com.anywhere.dependency_injection_hilt.data.remote.api

import com.anywhere.dependency_injection_hilt.data.remote.model.ProductsResponse
import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductsResponse
}