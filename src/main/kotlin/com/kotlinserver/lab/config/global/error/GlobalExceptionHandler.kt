package com.kotlinserver.lab.config.global.error

import com.kotlinserver.lab.config.global.error.exception.EntityNotFoundException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

private val logger = KotlinLogging.logger {  }


@RestControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex: EntityNotFoundException): ResponseEntity<ErrorResponse> {

        val response = ErrorResponse(ex.errorCode)
//
//        logger.info { "$result" }
//
//        return

//        return toResponseEntity(ex.errorCode)

//        return ResponseEntity<>(response, HttpStatus.BAD_REQUEST)
        logger.error { "#@#@#@#EntityNotFoundException : ${response.toString()} " }
        print(response.toString())

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

}