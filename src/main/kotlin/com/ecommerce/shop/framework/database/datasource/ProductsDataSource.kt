package com.ecommerce.shop.framework.database.datasource

import com.ecommerce.shop.application.repositories.ProductRepository
import com.ecommerce.shop.domain.Product
import com.ecommerce.shop.framework.database.dao.CategoriesDao
import com.ecommerce.shop.framework.database.dao.ProductsDao
import com.ecommerce.shop.framework.database.mappers.toDomain
import com.ecommerce.shop.framework.database.mappers.toEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductsDataSource : ProductRepository {

    @Autowired
    private lateinit var productsDao: ProductsDao

    @Autowired
    private lateinit var categoriesDao: CategoriesDao

    override fun findAll(): List<Product> {
        return productsDao.findAll().map { it.toDomain() }
    }

    override fun findById(id: Long): Product {
        return productsDao.findById(id).get().toDomain()
    }

    override fun save(t: Product): Product {
        return productsDao.save(t.toEntity()).toDomain()
    }

    override fun update(id: Long, t: Product): Product {
        val product = productsDao.findById(id).get()
        product.name = t.name
        product.description = t.description
        product.price = t.price
        product.stock = t.stock
        return productsDao.save(product).toDomain()
    }

    override fun delete(id: Long) {
        productsDao.deleteById(id)
    }

    override fun findEmpty(id: Long): Boolean {
        val product = productsDao.findById(id)
        return product.isPresent
    }

    override fun associateCategory(id_product: Long, id_category: Long): Product {
        val pro= productsDao.findById(id_product).get()
        val cat = categoriesDao.findById(id_category).get()
        pro.categories.add(cat)
        return productsDao.save(pro).toDomain()
    }


}