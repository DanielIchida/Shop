package com.ecommerce.shop.framework.controllers.dto


data class ProductDto(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,
    val categories: List<CategoryDto> = mutableListOf()
)