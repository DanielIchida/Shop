package com.ecommerce.shop.application.services.category

import com.ecommerce.shop.application.repositories.CategoryRepository
import com.ecommerce.shop.application.services.common.Service
import com.ecommerce.shop.domain.Category


class CategoryService(categoryRepository: CategoryRepository) : Service<Category>(categoryRepository) {
}