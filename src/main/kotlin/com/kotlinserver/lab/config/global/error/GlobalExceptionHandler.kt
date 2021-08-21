package com.kotlinserver.lab.config.global.error

import com.kotlinserver.lab.config.global.error.exception.EntityNotFoundException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val logger = KotlinLogging.logger {  }


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex: EntityNotFoundException): ResponseEntity<ErrorResponse> {

        logger.error { "EntityNotFoundException : $ex " }
        val response = ErrorResponse(ex.errorCode)
        val result = ResponseEntity(response, HttpStatus.BAD_REQUEST)

        logger.info { "$result" }

        return result
    }

}