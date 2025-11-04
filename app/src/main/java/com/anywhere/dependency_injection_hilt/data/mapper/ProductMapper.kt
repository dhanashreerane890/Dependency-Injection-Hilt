package com.anywhere.dependency_injection_hilt.data.mapper

import com.anywhere.dependency_injection_hilt.data.local.entity.ProductEntity
import com.anywhere.dependency_injection_hilt.data.remote.model.ProductDto
import com.anywhere.dependency_injection_hilt.domain.model.Product

fun ProductDto.toEntity() = ProductEntity(
    id = id,
    title = title,
    description = description,
    price = price,
    thumbnail = thumbnail,
    category = category
)

fun ProductEntity.toDomain() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    thumbnail = thumbnail,
    category = category
)