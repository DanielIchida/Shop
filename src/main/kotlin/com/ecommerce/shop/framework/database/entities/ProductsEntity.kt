package com.ecommerce.shop.framework.database.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.lang.Nullable
import javax.persistence.*

@Entity(name = "products")
data class ProductsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var name: String,
    var description: String,
    var price: Double,
    var stock: Int,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "products_categories",
              joinColumns = [JoinColumn(name = "categories_id", referencedColumnName = "id")],
              inverseJoinColumns = [JoinColumn(name = "products_id", referencedColumnName = "id")]
    )
    val categories: MutableList<CategoriesEntity>,
    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    val ecommerce: List<ECommerceEntity>
)