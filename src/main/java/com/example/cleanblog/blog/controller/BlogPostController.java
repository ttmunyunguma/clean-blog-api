package com.example.cleanblog.blog.controller;

import com.example.cleanblog.blog.entity.BlogPost;
import com.example.cleanblog.blog.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogPostController {

    private final BlogPostService blogPostService;

    @GetMapping("/allPosts")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts(){
        return new ResponseEntity<>(blogPostService.getAllBlogPosts(), HttpStatus.OK);
    }
}
