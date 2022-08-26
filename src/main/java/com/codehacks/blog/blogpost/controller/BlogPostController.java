package com.codehacks.blog.blogpost.controller;

import com.codehacks.blog.blogpost.entities.BlogPost;
import com.codehacks.blog.blogpost.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/blog")
public class BlogPostController {

    @Autowired
    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping(path="/create_post")
    public void createBlogPost(@RequestBody BlogPost blogPost) {
        this.blogPostService.createABlogPost(blogPost);
    }

    @GetMapping(path = "/{title}")
    public List<BlogPost> getBlogPost(@PathVariable String title) {
        return this.blogPostService.getBlogPostByTitle(title);
    }

    @PutMapping(path = "/update/{title}")
    public void updateBlogPost(@RequestBody BlogPost post) {
        blogPostService.updateBlogContent(post);
    }

    @DeleteMapping(path = "/{title}")
    public void deleteBlogPost(@PathVariable String title) {
        blogPostService.deleteABlogPost(title);
    }
}
