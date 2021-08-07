package com.kotlinserver.lab.domain.post.service

import com.kotlinserver.lab.domain.post.dto.PostReqDto
import com.kotlinserver.lab.domain.post.dto.PostResDto
import com.kotlinserver.lab.domain.post.entity.Post
import com.kotlinserver.lab.domain.post.enum.IsDeleted.*
import com.kotlinserver.lab.domain.post.repository.PostRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class PostService(
    private var postRepository: PostRepository
) {


    @Transactional
    fun createPost(postReqDto: PostReqDto): PostResDto {
        val post: Post = postRepository.save(postReqDto.dtoToEntity())
        return PostResDto.entityToDto_v2(post)
    }

    @Transactional
    fun readPost(postId: Long): PostResDto {
        val post: Post = postRepository.findById(postId).get();

        if(post.isDeleted == Y) {
            return PostResDto(
                id = null,
                title = "삭제된 글 입니다.",
                contents = "삭제된 내용입니다.",
                isDeleted = null,
                view = null)
        }
        post.addView()
        postRepository.save(post)
        return PostResDto.entityToDto_v2(post);
    }

    @Transactional(readOnly = true)
    fun readAllPost(): List<PostResDto> {
        val postList: List<Post> = postRepository.findAll()
        var postResDtoList: ArrayList<PostResDto> = arrayListOf()

        for(post: Post in postList) {
            postResDtoList.add(PostResDto.entityToDto_v2(post))
        }

        return postResDtoList
    }

    @Transactional
    fun updatePost(postId: Long, postReqDto: PostReqDto): PostResDto {
        var post: Post = postRepository.findById(postId).get()
        post.updatePost(postReqDto)
        postRepository.save(post)

        return PostResDto.entityToDto_v2(post);
    }

    @Transactional
    fun deletePost(postId: Long): String {
        var post: Post = postRepository.findById(postId).get()
        post.isDeleted = Y
        return "delete success"
    }


}