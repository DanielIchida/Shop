package com.ecommerce.shop.application.exception

class ExceptionUserNoExits(private val msg: String) : RuntimeException(msg) {
}