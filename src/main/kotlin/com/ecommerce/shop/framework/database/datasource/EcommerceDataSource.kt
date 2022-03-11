package com.ecommerce.shop.framework.database.datasource

import com.ecommerce.shop.application.repositories.ECommerceRepository
import com.ecommerce.shop.domain.ECommerce
import com.ecommerce.shop.framework.database.dao.CategoriesDao
import com.ecommerce.shop.framework.database.dao.ECommerceDao
import com.ecommerce.shop.framework.database.dao.ProductsDao
import com.ecommerce.shop.framework.database.mappers.toDomain
import com.ecommerce.shop.framework.database.mappers.toEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EcommerceDataSource : ECommerceRepository {

    @Autowired
    private lateinit var eCommerceDao: ECommerceDao

    @Autowired
    private lateinit var categoriesDao: CategoriesDao

    @Autowired
    private lateinit var productsDao: ProductsDao

    override fun associateCategory(id_ecommerce: Long, id_category: Long): ECommerce {
        val eCommerce = eCommerceDao.findById(id_ecommerce).get()
        val category = categoriesDao.findById(id_category).get()
        eCommerce.categories.add(category)
        return eCommerceDao.save(eCommerce).toDomain()
    }

    override fun associateProduct(id_ecommerce: Long, id_product: Long): ECommerce {
        val eCommerce = eCommerceDao.findById(id_ecommerce).get()
        val product = productsDao.findById(id_product).get()
        eCommerce.products.add(product)
        return eCommerceDao.save(eCommerce).toDomain()
    }

    override fun findAll(): List<ECommerce> {
        return eCommerceDao.findAll().map { it.toDomain() }
    }

    override fun findById(id: Long): ECommerce {
        return eCommerceDao.findById(id).get().toDomain()
    }

    override fun save(t: ECommerce): ECommerce {
       return eCommerceDao.save(t.toEntity()).toDomain()
    }

    override fun update(id: Long, t: ECommerce): ECommerce {
        val eCommerce = eCommerceDao.findById(id).get()
        eCommerce.name = t.name
        eCommerce.description = t.description
        eCommerce.phone = t.phone
        eCommerce.email = t.email
        eCommerce.cellphone = t.cellphone
        eCommerce.urlBanner = t.urlBanner
        eCommerce.urlLogo = t.urlLogo
        eCommerce.state = t.state
        return eCommerceDao.save(eCommerce).toDomain()
    }

    override fun delete(id: Long) {
        eCommerceDao.deleteById(id)
    }

    override fun findEmpty(id: Long): Boolean {
        return eCommerceDao.findById(id).isPresent
    }
}