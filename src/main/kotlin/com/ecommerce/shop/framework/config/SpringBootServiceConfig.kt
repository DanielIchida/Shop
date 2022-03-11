package com.ecommerce.shop.framework.config

import com.ecommerce.shop.application.repositories.CategoryRepository
import com.ecommerce.shop.application.repositories.ECommerceRepository
import com.ecommerce.shop.application.repositories.ProductRepository
import com.ecommerce.shop.application.services.category.CategoryService
import com.ecommerce.shop.application.services.ecommerce.ECommerceService
import com.ecommerce.shop.application.services.product.ProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringBootServiceConfig {

    @Bean
    fun categoriesServices(categoryRepository: CategoryRepository) : CategoryService {
        return CategoryService(categoryRepository)
    }

    @Bean
    fun productsServices(productRepository: ProductRepository,
                         categoryRepository: CategoryRepository) : ProductService {
        return ProductService(productRepository,categoryRepository)
    }

    @Bean
    fun ecommerceService(
        eCommerceRepository: ECommerceRepository,
        categoryRepository: CategoryRepository,
        productRepository: ProductRepository
    ) : ECommerceService{
        return ECommerceService(eCommerceRepository,categoryRepository,productRepository)
    }

}