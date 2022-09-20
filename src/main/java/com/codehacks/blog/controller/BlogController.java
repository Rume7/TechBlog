package com.codehacks.blog.controller;

import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class BlogController {

    private Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping(value = "/home")
    public ModelAndView index() {
        logger.info("Request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogPosts", blogPostService.getAllBlogPosts());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault())
                .toLocalDate().getDayOfWeek());
        return modelAndView;
    }
}
