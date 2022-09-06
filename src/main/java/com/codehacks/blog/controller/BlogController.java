package com.codehacks.blog.controller;

import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogPostService blogPostService;

    // TODO: Implemented methods

    @GetMapping("/all_posts")
    public List<BlogPost> getAllBlogPost(Model model) {
        logger.info("Request to Get all Blog posts");
        List<BlogPost> allPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("allPosts", allPosts);
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/posts/title")
    public BlogPost getPost(@PathVariable("title") String title, Model model) {
        /*
        BlogPost post = blogPostService.getBlogPostByTitle(title);
        model.addAttribute("aPost", post);
        return post;

         */
        return null;
    }


}
