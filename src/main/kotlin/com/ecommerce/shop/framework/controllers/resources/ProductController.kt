package com.ecommerce.shop.framework.controllers.resources

import com.ecommerce.shop.application.services.product.ProductService
import com.ecommerce.shop.framework.controllers.dto.ProductDto
import com.ecommerce.shop.framework.controllers.mappers.toDomain
import com.ecommerce.shop.framework.controllers.mappers.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("products")
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping
    fun getAll() : ResponseEntity<List<ProductDto>>{
        return ResponseEntity(productService.findAll().map { it.toDto()},HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<ProductDto>{
        return ResponseEntity(productService.findById(id).toDto(),HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody request: ProductDto) : ResponseEntity<ProductDto>{
        return ResponseEntity(productService.save(request.toDomain()).toDto(),HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long,@RequestBody request: ProductDto) : ResponseEntity<ProductDto>{
        return ResponseEntity(productService.update(id,request.toDomain()).toDto(),HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Boolean>{
        productService.delete(id)
        return ResponseEntity(true,HttpStatus.OK)
    }

    @PostMapping("associate/category/{id_product}/{id_category}")
    fun associateCategory(@PathVariable id_product: Long,
                          @PathVariable id_category: Long) : ResponseEntity<ProductDto>{
        return ResponseEntity(productService.associateCategory(id_product,id_category).toDto(),HttpStatus.OK)
    }


}