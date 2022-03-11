package com.ecommerce.shop.framework.controllers.resources

import com.ecommerce.shop.application.services.category.CategoryService
import com.ecommerce.shop.framework.controllers.dto.CategoryDto
import com.ecommerce.shop.framework.controllers.mappers.toDomain
import com.ecommerce.shop.framework.controllers.mappers.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("categories")
class CategoryController {

    @Autowired
    private lateinit var categoryService: CategoryService

    @GetMapping
    fun getAll() : ResponseEntity<List<CategoryDto>>{
        return ResponseEntity(categoryService.findAll().map { it.toDto() },HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody request: CategoryDto) : ResponseEntity<CategoryDto>{
        return ResponseEntity(categoryService.save(request.toDomain()).toDto(),HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long,@RequestBody request: CategoryDto) : ResponseEntity<CategoryDto>{
        return ResponseEntity(categoryService.update(id,request.toDomain()).toDto(),HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Boolean>{
       categoryService.delete(id)
       return ResponseEntity(true,HttpStatus.OK)
    }

}