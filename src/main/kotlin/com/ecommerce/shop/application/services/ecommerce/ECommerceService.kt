package com.ecommerce.shop.application.services.ecommerce

import com.ecommerce.shop.application.exception.ExceptionUserNoExits
import com.ecommerce.shop.application.exception.MessageException
import com.ecommerce.shop.application.repositories.CategoryRepository
import com.ecommerce.shop.application.repositories.ECommerceRepository
import com.ecommerce.shop.application.repositories.ProductRepository
import com.ecommerce.shop.application.services.common.Extension
import com.ecommerce.shop.application.services.common.Service
import com.ecommerce.shop.domain.ECommerce


class ECommerceService(
    private val eCommerceRepository: ECommerceRepository,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : Service<ECommerce>(eCommerceRepository) {

    fun associateCategory(id_ecommerce: Long,id_category: Long) : ECommerce{
        val validate = Extension.validateJoin(id_ecommerce,id_category,eCommerceRepository,categoryRepository)
        if(validate){
            return eCommerceRepository.associateCategory(id_ecommerce,id_category)
        }else{
            throw ExceptionUserNoExits(MessageException.NO_MESSAGE_EXISTS + " " +
                        "${MessageException.NAME_ECOMMERCE} = $id_ecommerce " +
                        "${MessageException.NAME_CATEGORY} = $id_category"
            )
        }
    }

    fun associateProduct(id_ecommerce: Long,id_product: Long) : ECommerce{
        val validate = Extension.validateJoin(id_ecommerce,id_product,eCommerceRepository,productRepository)
        if(validate){
            return eCommerceRepository.associateProduct(id_ecommerce,id_product)
        }else{
            throw ExceptionUserNoExits(MessageException.NO_MESSAGE_EXISTS + " " +
                        "${MessageException.NAME_ECOMMERCE} = $id_ecommerce " +
                        "${MessageException.NAME_CATEGORY} = $id_product"
            )
        }
    }


}