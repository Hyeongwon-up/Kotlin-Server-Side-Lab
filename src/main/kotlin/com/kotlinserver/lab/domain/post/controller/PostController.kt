package com.kotlinserver.lab.domain.post.controller


import com.kotlinserver.lab.domain.post.dto.PostReqDto
import com.kotlinserver.lab.domain.post.dto.PostResDto
import com.kotlinserver.lab.domain.post.service.PostService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@Api(value = "PostController")
@RestController
class PostController(private var postService: PostService) {


    @ApiOperation(value = "게시글 생성")
    @PostMapping("/post")
    fun createPost(postReqDto: PostReqDto): PostResDto {
        return postService.createPost(postReqDto)
    }

    @ApiOperation(value = "게시글Id로 조회")
    @GetMapping("/post/{postId}")
    fun readPost(@PathVariable postId: Long): PostResDto {
        return postService.readPost(postId)
    }

    @ApiOperation(value = "모든 게시글 조회")
    @GetMapping("/post")
    fun readAllPost(): List<PostResDto> {
        return postService.readAllPost()
    }

    @ApiOperation(value = "해당Id 게시글 수정")
    @PutMapping("/post/{postId}")
    fun updatePost(@PathVariable postId: Long, postReqDto: PostReqDto): PostResDto {
        return postService.updatePost(postId, postReqDto)
    }

    @ApiOperation(value = "해당Id 게시글 삭제")
    @DeleteMapping("/post/{postId}")
    fun deletePost(@PathVariable postId: Long): String {
        return postService.deletePost(postId)
    }


}