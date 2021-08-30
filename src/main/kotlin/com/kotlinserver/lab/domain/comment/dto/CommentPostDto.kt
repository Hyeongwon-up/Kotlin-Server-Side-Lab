package com.kotlinserver.lab.domain.comment.dto

data class CommentPostDto(
     val postId: Long,
     val parentCommentId: Long,
     val content: String
)
