package com.kotlinserver.lab.config.global.error

import lombok.Builder
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap


private val logger = KotlinLogging.logger {  }

//fun toResponseEntity(errorCode: ErrorCode): ResponseEntity<ErrorResponse> {
//
//
//    logger.info { "??? $errorCode" }
//
//    return ResponseEntity.ok(
//        (ErrorResponse(
//            status = errorCode.status,
//            message = errorCode.message,
//            code = errorCode.errorCode
//        ))
//    )
//}

data class ErrorResponse(
    private val status: Int,
    private val message: String,
    private val code: String
) {

    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message, errorCode.errorCode)



}