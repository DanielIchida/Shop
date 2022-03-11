package com.ecommerce.shop.domain

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,
    val categories: List<Category>
)