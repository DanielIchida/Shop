package com.ecommerce.shop.framework.database.dao

import com.ecommerce.shop.framework.database.entities.ECommerceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ECommerceDao : JpaRepository<ECommerceEntity,Long> {
}