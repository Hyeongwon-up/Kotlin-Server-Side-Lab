package com.kotlinserver.lab.domain.post.dto

import com.kotlinserver.lab.domain.post.entity.Post

data class PostReqDto(

    var title: String,
    var contents: String

    ) {
    fun dtoToEntity(): Post {
        return Post(title = title, contents = contents)
    }
}




