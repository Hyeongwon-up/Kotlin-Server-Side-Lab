package com.kotlinserver.lab.domain.comment.service

import com.kotlinserver.lab.domain.comment.dao.CommentRepository
import com.kotlinserver.lab.domain.comment.dto.CommentPostDto
import com.kotlinserver.lab.domain.comment.entity.Comment
import com.kotlinserver.lab.domain.post.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class CommentService(
    private final val postRepository: PostRepository,
    private final val commentRepository: CommentRepository
) {

    fun createComment(postDto: CommentPostDto): Comment {
        val post = postRepository.findById(postDto.postId).get()
        val comment = Comment(content = postDto.content, post = post)
        return commentRepository.save(comment)
    }
}