package com.kotlinserver.lab.domain.post.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.kotlinserver.lab.domain.comment.entity.Comment
import com.kotlinserver.lab.domain.post.dto.PostReqDto
import com.kotlinserver.lab.domain.post.enum.IsDeleted
import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

@Entity
@Table(name = "post")
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    var id: Long = 0,

    var title: String,

    var contents: String,

    @ColumnDefault("0")
    var view: Long = 0,

    @Enumerated(EnumType.STRING)
    var isDeleted: IsDeleted = IsDeleted.N,

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val comment: Set<Comment> = HashSet<Comment>()

) {

    fun addView() {
        this.view++
    }

    fun updatePost(postReqDto: PostReqDto) {
        this.title = postReqDto.title
        this.contents = postReqDto.contents
    }
}