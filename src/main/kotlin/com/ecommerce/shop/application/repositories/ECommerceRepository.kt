package com.ecommerce.shop.application.repositories

import com.ecommerce.shop.domain.ECommerce

interface ECommerceRepository : BaseRepository<ECommerce>{
    fun associateCategory(id_ecommerce: Long,id_category: Long) : ECommerce
    fun associateProduct(id_ecommerce: Long,id_product: Long) : ECommerce
}