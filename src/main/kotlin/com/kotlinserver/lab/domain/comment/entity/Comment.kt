package com.kotlinserver.lab.domain.comment.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.kotlinserver.lab.domain.post.entity.Post
import com.kotlinserver.lab.domain.post.enum.IsDeleted
import lombok.Setter
import javax.persistence.*

@Entity
class Comment(

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0,

    @lombok.Setter
    private val content: String,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private val post: Post,

)