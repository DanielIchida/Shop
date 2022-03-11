package com.ecommerce.shop.framework.database.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "categories")
data class CategoriesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var name: String,
    var status: Boolean,
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    val products: List<ProductsEntity>,
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    val ecommerce: List<ECommerceEntity>
)

