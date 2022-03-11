
package com.ecommerce.shop.application.services.product

import com.ecommerce.shop.application.exception.ExceptionUserNoExits
import com.ecommerce.shop.application.exception.MessageException
import com.ecommerce.shop.application.repositories.CategoryRepository
import com.ecommerce.shop.application.repositories.ProductRepository
import com.ecommerce.shop.application.services.common.Extension
import com.ecommerce.shop.application.services.common.Service
import com.ecommerce.shop.domain.Product

class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
    ) : Service<Product>(productRepository){

    fun associateCategory(id_product: Long,id_category: Long) : Product{
        val validate = Extension.validateJoin(id_product,id_category,productRepository,categoryRepository)
        if(validate){
            return productRepository.associateCategory(id_product,id_category)
        }else{
            throw ExceptionUserNoExits(MessageException.NO_MESSAGE_EXISTS + " " +
                    "${MessageException.NAME_ECOMMERCE} = $id_product " +
                    "${MessageException.NAME_CATEGORY} = $id_category"
            )
        }
    }
}