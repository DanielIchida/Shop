package com.ecommerce.shop.framework.database.mappers

import com.ecommerce.shop.domain.Product
import com.ecommerce.shop.framework.database.entities.ProductsEntity


fun ProductsEntity.toDomain() : Product = Product(
    id = id,
    name = name,
    description = description,
    price = price,
    stock = stock,
    categories = categories.map { it.toDomain() }
)

fun Product.toEntity() : ProductsEntity = ProductsEntity(
    id = id,
    name = name,
    description = description,
    price = price,
    stock = stock,
    categories = categories.map { it.toEntity() }.toMutableList(),
    ecommerce = mutableListOf()
)