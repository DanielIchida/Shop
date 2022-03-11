package com.ecommerce.shop.framework.database.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "ecommerce")
data class ECommerceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var name: String,
    var description: String,
    var phone: String,
    var cellphone: String,
    val address: String,
    var state: String,
    @Column(name = "url_logo")
    var urlLogo: String,
    @Column(name = "url_banner")
    var urlBanner: String,
    var email: String,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "ecommerce_products",
        joinColumns = [JoinColumn(name = "ecommerce_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "products_id", referencedColumnName = "id")]
    )
    val products: MutableList<ProductsEntity>,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "ecommerce_categories",
        joinColumns = [JoinColumn(name = "ecommerce_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "categories_id", referencedColumnName = "id")]
    )
    val categories: MutableList<CategoriesEntity>,
)