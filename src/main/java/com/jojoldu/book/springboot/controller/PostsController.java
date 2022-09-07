package com.jojoldu.book.springboot.controller;

import com.jojoldu.book.springboot.controller.dto.PostsResponseDto;
import com.jojoldu.book.springboot.controller.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.controller.dto.PostsUpdateRequestDto;
import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@NoArgsConstructor 기본 생성자 자동 추가 public 생성자(){} 와 같은 효과
@RequiredArgsConstructor
@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
