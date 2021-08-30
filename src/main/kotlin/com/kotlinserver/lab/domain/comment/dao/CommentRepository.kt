package com.kotlinserver.lab.domain.comment.dao

import com.kotlinserver.lab.domain.comment.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Long> {
}