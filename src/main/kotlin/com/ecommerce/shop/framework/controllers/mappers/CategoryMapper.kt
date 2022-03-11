package com.ecommerce.shop.framework.controllers.mappers

import com.ecommerce.shop.domain.Category
import com.ecommerce.shop.framework.controllers.dto.CategoryDto

fun CategoryDto.toDomain() : Category = Category(
    id = id,
    name = name,
    status = status
)

fun Category.toDto() : CategoryDto = CategoryDto(
    id = id,
    name = name,
    status = status
)