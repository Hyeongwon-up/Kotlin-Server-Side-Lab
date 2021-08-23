package com.kotlinserver.lab.config.global.error

enum class ErrorCode(
     val status: Int,
     val errorCode: String,
     val message: String
) {

    ENTITY_NOT_FOUND(404, "COM005", "Entity not found"),

}