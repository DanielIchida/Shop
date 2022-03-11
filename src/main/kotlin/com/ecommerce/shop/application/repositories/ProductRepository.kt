package com.ecommerce.shop.application.repositories

import com.ecommerce.shop.domain.Product

interface ProductRepository : BaseRepository<Product>{
    fun associateCategory(id_product: Long,id_category: Long) : Product
}