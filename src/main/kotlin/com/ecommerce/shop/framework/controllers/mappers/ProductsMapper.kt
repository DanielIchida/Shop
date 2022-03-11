package com.ecommerce.shop.framework.controllers.mappers

import com.ecommerce.shop.domain.Product
import com.ecommerce.shop.framework.controllers.dto.ProductDto


fun ProductDto.toDomain() : Product = Product(
    id = id,
    name = name,
    description = description,
    price = price,
    stock = stock,
    categories = categories.map { it.toDomain() }
)

fun Product.toDto() : ProductDto = ProductDto(
    id = id,
    name= name,
    description = description,
    price = price,
    stock = stock,
    categories = categories.map { it.toDto() }
)