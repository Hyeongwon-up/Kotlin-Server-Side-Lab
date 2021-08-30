package com.kotlinserver.lab.domain.comment.api

import com.kotlinserver.lab.domain.comment.dto.CommentPostDto
import com.kotlinserver.lab.domain.comment.entity.Comment
import com.kotlinserver.lab.domain.comment.service.CommentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController(
    private final val commentService: CommentService
) {
    @PostMapping("/comment")
    fun createComment(@RequestBody commentPostDto: CommentPostDto): Comment {
        return commentService.createComment(commentPostDto);
    }
}