package com.ecommerce.shop.application.services.common

import com.ecommerce.shop.application.repositories.BaseRepository

open class Service<T>(private val baseRepository: BaseRepository<T>){

    fun findAll(): List<T> {
        val list = baseRepository.findAll()
        list.ifEmpty { return mutableListOf() }
        return list
    }

    fun findById(id: Long) : T{
        return baseRepository.findById(id)
    }

    fun save(t: T) : T{
        return baseRepository.save(t)
    }

    fun update(id: Long,t: T) : T{
        return baseRepository.update(id,t)
    }

    fun delete(id: Long){
        val obj = baseRepository.findById(id)
        if(obj != null){
           baseRepository.delete(id)
        }
    }

    fun findEmpty(id: Long) : Boolean{
        return baseRepository.findEmpty(id)
    }



}