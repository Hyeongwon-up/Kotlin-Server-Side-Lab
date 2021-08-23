package com.kotlinserver.lab.domain.post.dto

import com.kotlinserver.lab.domain.post.entity.Post
import com.kotlinserver.lab.domain.post.enum.IsDeleted

data class PostResDto(

    var id: Long?,
    var title: String,
    var contents: String,
    var view: Long?,
    var isDeleted: IsDeleted?

) {

    companion object {
        fun entityToDto_v2(post: Post): PostResDto {
            return post.run {
                PostResDto(id = id, title = title, contents = contents, view = view, isDeleted = isDeleted)
            }
        }
    }


}
