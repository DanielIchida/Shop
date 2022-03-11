package com.ecommerce.shop.framework.database.datasource
import com.ecommerce.shop.application.repositories.CategoryRepository
import com.ecommerce.shop.domain.Category
import com.ecommerce.shop.framework.database.dao.CategoriesDao
import com.ecommerce.shop.framework.database.mappers.toDomain
import com.ecommerce.shop.framework.database.mappers.toEntity
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoriesDataSource : CategoryRepository {

    @Autowired
    private lateinit var categoriesDao: CategoriesDao

    override fun findAll(): List<Category> {
        return categoriesDao.findAll().map { it.toDomain() }
    }

    override fun findById(id: Long): Category {
        return categoriesDao.findById(id).get().toDomain()
    }

    override fun save(t: Category): Category {
        return categoriesDao.save(t.toEntity()).toDomain()
    }

    override fun update(id: Long, t: Category): Category {
        val updateCategory = categoriesDao.findById(id).get()
        updateCategory.name = t.toEntity().name
        updateCategory.status = t.toEntity().status
        return categoriesDao.save(updateCategory).toDomain()
    }

    override fun delete(id: Long) {
        return categoriesDao.deleteById(id)
    }

    override fun findEmpty(id: Long): Boolean {
        val category = categoriesDao.findById(id)
        return category.isPresent
    }

}