package com.kotlinserver.lab.config.global.error.exception

import com.kotlinserver.lab.config.global.error.ErrorCode

class EntityNotFoundException(
     val errorCode: ErrorCode
): RuntimeException() {

}