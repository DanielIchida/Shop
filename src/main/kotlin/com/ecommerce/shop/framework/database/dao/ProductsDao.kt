package com.ecommerce.shop.framework.database.dao

import com.ecommerce.shop.framework.database.entities.ProductsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsDao : JpaRepository<ProductsEntity,Long> {
}