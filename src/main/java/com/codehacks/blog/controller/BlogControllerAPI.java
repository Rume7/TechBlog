package com.codehacks.blog.controller;

import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
public class BlogControllerAPI {

    private final Logger logger = LoggerFactory.getLogger(BlogControllerAPI.class);

    @Autowired
    private BlogPostService blogPostService;

    // TODO: Implemented CRUD methods
    // TODO DONE:  READ,

    @GetMapping(value = "/all_posts", produces = "application/json")
    public List<BlogPost> getAllBlogPost() {
        logger.info("Request to Get all Blog posts");
        List<BlogPost> allPosts = blogPostService.getAllBlogPosts();
        //model.addAttribute("allPosts", allPosts);
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping(value = "/posts", produces = "application/json")
    public BlogPost getPost(@RequestParam String title, Model model) {
        logger.info("Request to Get a blog post titled: " + title);
        final BlogPost blogPost = blogPostService.getBlogPostByTitle(title);
        return blogPost == null ? null : blogPost;
    }

    @PutMapping
    public BlogPost updatePost(@RequestBody BlogPost post) {
        logger.info("Request to UPDATE a blog post titled: " + post.getTitle());
        blogPostService.updateBlogContent(post);
        return blogPostService.getBlogPostByTitle(post.getTitle());
    }
}
