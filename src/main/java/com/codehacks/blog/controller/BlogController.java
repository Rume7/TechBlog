package com.codehacks.blog.controller;

import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(BlogPost.class);

    @Autowired
    private BlogPostService blogPostService;

    // TODO: Implemented methods


}
