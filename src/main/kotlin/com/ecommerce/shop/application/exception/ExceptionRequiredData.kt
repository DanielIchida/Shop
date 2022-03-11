package com.ecommerce.shop.application.exception

class ExceptionRequiredData(private val msg: String) : RuntimeException(msg){
}