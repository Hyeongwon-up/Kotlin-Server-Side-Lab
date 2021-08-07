package com.kotlinserver.lab.domain.post.repository

import com.kotlinserver.lab.domain.post.entity.Post
import com.kotlinserver.lab.domain.post.enum.IsDeleted
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, Long> {

    fun countAllByIsDeleted(isDeleted: IsDeleted): Long

}