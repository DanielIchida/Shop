package com.ecommerce.shop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(
	basePackages = ["com.ecommerce.shop.framework.database.dao"]
)
@Configuration
@EnableJpaAuditing
@SpringBootApplication
@EntityScan(
	basePackages = ["com.ecommerce.shop.domain","com.ecommerce.shop.framework.database.entities"]
)
class ShopApplication

fun main(args: Array<String>) {
	runApplication<ShopApplication>(*args)
}
