package com.ecommerce.shop.framework.database.mappers

import com.ecommerce.shop.domain.ECommerce
import com.ecommerce.shop.framework.database.entities.ECommerceEntity

fun ECommerceEntity.toDomain(): ECommerce = ECommerce(
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
    products = products.map { it.toDomain() },
    categories = categories.map { it.toDomain() }
)

fun ECommerce.toEntity(): ECommerceEntity = ECommerceEntity(
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
    products = products.map { it.toEntity() }.toMutableList(),
    categories = categories.map { it.toEntity() }.toMutableList()
)