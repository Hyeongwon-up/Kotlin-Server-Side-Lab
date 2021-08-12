package com.kotlinserver.lab.domain.post.service

import com.kotlinserver.lab.domain.post.dto.PostReqDto
import com.kotlinserver.lab.domain.post.entity.Post
import com.kotlinserver.lab.domain.post.enum.IsDeleted
import com.kotlinserver.lab.domain.post.repository.PostRepository
import com.kotlinserver.lab.utils.slack.SlackService
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.scheduling.annotation.AsyncResult
import java.util.*

@SpringBootTest
class PostServiceTest : StringSpec({


    val postRepository = mockk<PostRepository>()
    val slackService = mockk<SlackService>()
    val postService = PostService(postRepository, slackService)

    lateinit var postReqDto: PostReqDto
    lateinit var post: Post

    beforeEach(){
        println("Before Each 실행")
        postReqDto = PostReqDto(title = "테스트 제목", contents = "테스트 내용")
        post = Post(id = 2L, title = "테스트 제목", contents = "테스트 내용", view = 1, isDeleted = IsDeleted.N)
    }


    "글 생성하기 테스트"{

        //given
        every { postRepository.save(any()) } returns post
        every { slackService.sendMessage(any()) } returns AsyncResult(true)

        //when
        val result = postService.createPost(postReqDto)

        //then

        verifyAll { //호출검증
           postRepository.save(any())
           slackService.sendMessage(any())
        }
        result.title.shouldBe(postReqDto.title)
        result.contents.shouldBe(postReqDto.contents)

    }

    "해당 Id글 읽어오기 _ 삭제 된 글이 아닐 경우 (조회수 증가 확인)" {

        //given
        every { postRepository.findById(any()).get() } returns post
        every { postRepository.save(any())} returns post

        //when
        val result = postService.readPost(2L);

        //then
        result.view.shouldBe(post.view++)
        result.id.shouldBe(post.id)

    }

    "해당 Id글 읽어오기 - 삭제 된 글 경우" {

        //given
        post.isDeleted = IsDeleted.Y
        every { postRepository.findById(any()).get() } returns post

        //when
        val result = postService.readPost(2L);

        //then
        result.id.shouldBe(null)
        result.title.shouldBe("삭제된 글 입니다.")
        result.title.shouldBe("삭제된 내용입니다.")

    }
//
//    "모든 글 읽어오기 - 삭제 된 글 제외하고 불러오는지 확인하기" {
//
//
//        //given
//        val testPostList :
//
//
//
//    }

    "글 수정하기 테스트 " {
        //given
        postReqDto = PostReqDto(title = "수정 된 제목", contents = "수정 된 내용")
        every{ postRepository.findById(any()).get()} returns post
        every { postRepository.save(any()) } returns post

        //when
        val result = postService.updatePost(2L, postReqDto)

        //then
        result.title.shouldBe("수정 된 제목")
        result.contents.shouldBe("수정 된 내용")
    }





})


