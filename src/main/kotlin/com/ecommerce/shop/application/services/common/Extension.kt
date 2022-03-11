package com.ecommerce.shop.application.services.common

import com.ecommerce.shop.application.repositories.BaseRepository

object Extension {

    fun <T> validate(id: Long,baseRepository: BaseRepository<T>) : Boolean{
        return baseRepository.findEmpty(id)
    }

    fun <T,M> validateJoin(
        id_table: Long,
        id_associate: Long,
        tableRepository: BaseRepository<T>,
        associateRepository: BaseRepository<M>
    ) : Boolean{
        return tableRepository.findEmpty(id_table) || associateRepository.findEmpty(id_associate)
    }

}