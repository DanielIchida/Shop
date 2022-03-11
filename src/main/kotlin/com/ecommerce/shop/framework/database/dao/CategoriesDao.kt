package com.ecommerce.shop.framework.database.dao

import com.ecommerce.shop.framework.database.entities.CategoriesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriesDao : JpaRepository<CategoriesEntity,Long>{
}