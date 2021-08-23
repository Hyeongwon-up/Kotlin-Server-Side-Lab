package com.kotlinserver.lab.config.global.error

import com.fasterxml.jackson.annotation.JsonProperty


data class ErrorResponse(
    @field:JsonProperty("status")
    private var status: Int,

    @field:JsonProperty("message")
    private var message: String,

    @field:JsonProperty("code")
    private var code: String
) {

    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message, errorCode.errorCode) {

    }



}