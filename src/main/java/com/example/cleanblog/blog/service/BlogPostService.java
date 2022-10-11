package com.example.cleanblog.blog.service;

import com.example.cleanblog.blog.entity.BlogPost;

import java.util.List;

public interface BlogPostService {
    BlogPost addNewBlogPost(BlogPost blogPost);
    BlogPost getBlogPostBySlug(String slug);
    List<BlogPost> getAllBlogPosts();
    void deleteBlogPostBySlug(String slug);
}
