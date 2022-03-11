package com.ecommerce.shop.domain

data class ECommerce(
    val id: Long,
    val name: String,
    val description: String,
    val phone: String,
    val cellphone: String,
    val address: String,
    val state: String,
    val urlLogo: String,
    val urlBanner: String,
    val email: String,
    val categories: List<Category>,
    val products: List<Product>
)
