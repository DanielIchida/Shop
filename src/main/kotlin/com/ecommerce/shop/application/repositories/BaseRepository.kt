package com.ecommerce.shop.application.repositories

interface BaseRepository<T> {
    fun findAll() : List<T>
    fun findById(id: Long) : T
    fun save(t: T) : T
    fun update(id:Long,t: T) : T
    fun delete(id: Long)
    fun findEmpty(id: Long) : Boolean
}