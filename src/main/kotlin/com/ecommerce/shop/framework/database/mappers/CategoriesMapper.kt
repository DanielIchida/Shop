package com.ecommerce.shop.framework.database.mappers

import com.ecommerce.shop.domain.Category
import com.ecommerce.shop.framework.database.entities.CategoriesEntity

fun CategoriesEntity.toDomain(): Category = Category(
    id = id,
    name = name,
    status = status,
)

fun Category.toEntity() : CategoriesEntity = CategoriesEntity(
    id = id,
    name = name,
    status = status,
    products = mutableListOf(),
    ecommerce = mutableListOf()
)