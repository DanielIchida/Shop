package com.ecommerce.shop.framework.controllers.resources

import com.ecommerce.shop.application.services.ecommerce.ECommerceService
import com.ecommerce.shop.framework.controllers.dto.ECommerceDto
import com.ecommerce.shop.framework.controllers.mappers.toDomain
import com.ecommerce.shop.framework.controllers.mappers.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("ecommerce")
class ECommerceController {

    @Autowired
    private lateinit var eCommerceService: ECommerceService

    @GetMapping
    fun getAll() : ResponseEntity<List<ECommerceDto>>{
        return ResponseEntity(eCommerceService.findAll().map { it.toDto() },HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<ECommerceDto>{
        return ResponseEntity(eCommerceService.findById(id).toDto(),HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody request: ECommerceDto) : ResponseEntity<ECommerceDto>{
        return ResponseEntity(eCommerceService.save(request.toDomain()).toDto(),HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long,@RequestBody request: ECommerceDto) : ResponseEntity<ECommerceDto> {
       return ResponseEntity(eCommerceService.update(id,request.toDomain()).toDto(),HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) :  ResponseEntity<Boolean>{
        eCommerceService.delete(id)
        return ResponseEntity(true,HttpStatus.OK)
    }

    @PostMapping("associate/category/{id_ecommerce}/{id_category}")
    fun associateCategory(@PathVariable id_ecommerce: Long,
                         @PathVariable id_category: Long) : ResponseEntity<ECommerceDto>{
        return ResponseEntity(eCommerceService.associateCategory(id_ecommerce,id_category).toDto(),HttpStatus.OK)
    }

    @PostMapping("associate/product/{id_ecommerce}/{id_product}")
    fun associateProduct(@PathVariable id_ecommerce: Long,
                          @PathVariable id_product: Long) : ResponseEntity<ECommerceDto>{
        return ResponseEntity(eCommerceService.associateProduct(id_ecommerce,id_product).toDto(),HttpStatus.OK)
    }



}