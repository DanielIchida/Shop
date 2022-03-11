package com.ecommerce.shop.framework.controllers.dto

import com.fasterxml.jackson.annotation.JsonIgnore

data class ECommerceDto(
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
    @JsonIgnore
    val products: List<ProductDto> = mutableListOf(),
    val categories: List<CategoryDto> = mutableListOf()
)