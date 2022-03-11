package com.ecommerce.shop.framework.controllers.error

import com.ecommerce.shop.application.exception.ExceptionRequiredData
import com.ecommerce.shop.application.exception.ExceptionUserNoExits
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.concurrent.ConcurrentHashMap

@ControllerAdvice
class HandlerError : ResponseEntityExceptionHandler() {

     private val state_codes: ConcurrentHashMap<String?,Int> = ConcurrentHashMap()

     init {
         state_codes[ExceptionUserNoExits::class.simpleName] = HttpStatus.CONFLICT.value()
         state_codes[ExceptionRequiredData::class.simpleName] = HttpStatus.BAD_REQUEST.value()
     }

     @ExceptionHandler(Exception::class)
     final fun handleAllException(exception: Exception) : ResponseEntity<Error>{
         val result: ResponseEntity<Error>
         val exceptionName = exception.javaClass.simpleName
         val message = exception.message
         val code = state_codes[exceptionName]
         if(code != null){
             val error = Error(exceptionName,message)
             result = ResponseEntity(error,HttpStatus.valueOf(code))
         }else{
             val error = Error(exceptionName,MessageError.A_PROBLEM_OCCURRED)
             result = ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR)
         }
         return result
     }

}