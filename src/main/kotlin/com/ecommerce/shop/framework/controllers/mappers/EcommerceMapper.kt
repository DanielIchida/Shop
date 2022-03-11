package com.ecommerce.shop.framework.controllers.mappers

import com.ecommerce.shop.domain.ECommerce
import com.ecommerce.shop.framework.controllers.dto.ECommerceDto



fun ECommerceDto.toDomain(): ECommerce = ECommerce(
    id = id,
    name = name,
    description = description,
    phone = phone,
    cellphone = cellphone,
    address = address,
    state = state,
    urlLogo = urlLogo,
    urlBanner = urlBanner,
    email = email,
    products = mutableListOf(),
    categories = categories.map { it.toDomain() }
)

fun ECommerce.toDto(): ECommerceDto = ECommerceDto(
    id = id,
    name = name,
    description = description,
    phone = phone,
    cellphone = cellphone,
    address = address,
    state = state,
    urlLogo = urlLogo,
    urlBanner = urlBanner,
    email = email,
    products = mutableListOf(),
    categories = categories.map { it.toDto() }
)