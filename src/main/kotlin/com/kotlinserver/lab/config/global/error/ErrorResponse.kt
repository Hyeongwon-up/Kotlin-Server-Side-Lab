package com.kotlinserver.lab.config.global.error

import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }

data class ErrorResponse(
    private val status: Int,
    private val message: String,
    private val code: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.status, errorCode.message, errorCode.errorCode) {
        logger.info { "constructer start ${errorCode.errorCode}" }
    }
}