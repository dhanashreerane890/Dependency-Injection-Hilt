package com.anywhere.dependency_injection_hilt.data.remote.repo

import com.anywhere.dependency_injection_hilt.data.local.dao.ProductDao
import com.anywhere.dependency_injection_hilt.data.mapper.toDomain
import com.anywhere.dependency_injection_hilt.data.mapper.toEntity
import com.anywhere.dependency_injection_hilt.data.remote.api.ProductApiService
import com.anywhere.dependency_injection_hilt.di.IoDispatcher
import com.anywhere.dependency_injection_hilt.di.MainDispatcher
import com.anywhere.dependency_injection_hilt.domain.model.Product
import com.anywhere.dependency_injection_hilt.domain.repo.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApiService,
    private val dao: ProductDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ProductRepository {

    override fun getProducts(): Flow<List<Product>> {
        return dao.getAllProducts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun refreshProducts() = withContext(ioDispatcher) {
        try {
            val response = api.getProducts()
            val entities = response.products.map { it.toEntity() }
            dao.clearAll()
            dao.insertProducts(entities)
            withContext(mainDispatcher) {
                println("Products refreshed successfully on main thread")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}