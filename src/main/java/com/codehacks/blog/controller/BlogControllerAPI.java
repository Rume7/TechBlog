package com.codehacks.blog.controller;

import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
public class BlogControllerAPI {

    private final Logger logger = LoggerFactory.getLogger(BlogControllerAPI.class);

    @Autowired
    private BlogPostService blogPostService;

    @Transactional
    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public String createPost(@RequestBody BlogPost post) {
        logger.info("Request to CREATE blog post titled: " + post.getTitle());
        blogPostService.createABlogPost(post);
        return "Successful";
    }

    @GetMapping(value = "/all_posts", produces = "application/json")
    public List<BlogPost> getAllBlogPost() {
        List<BlogPost> allPosts = blogPostService.getAllBlogPosts();
        logger.info("Request to GET all Blog posts. # of post = " + allPosts.size());
        return allPosts;
    }

    @GetMapping(value = "/posts/{title}", produces = "application/json")
    public BlogPost getPost(@PathVariable String title, Model model) {
        logger.info("Request to GET blog post titled: " + title);
        final BlogPost blogPost = blogPostService.getBlogPostByTitle(title);
        return blogPost == null ? null : blogPost;
    }

    @PutMapping(value = "/posts/update", produces = "application/json")
    public BlogPost updatePost(@RequestBody BlogPost post) {
        logger.info("Request to UPDATE a blog post titled: " + post.getTitle());
        blogPostService.updateBlogContent(post);
        return blogPostService.getBlogPostByTitle(post.getTitle());
    }

    @DeleteMapping(value = "/posts/delete/{title}")
    public boolean deletePost(@PathVariable String title) {
        logger.info("Request to DELETE the blog post titled: " + title);
        BlogPost retrievedPost = blogPostService.getBlogPostByTitle(title);
        if (retrievedPost != null) {
            blogPostService.deleteABlogPost(retrievedPost.getTitle());
            return true;
        }
        return false;
    }
}
