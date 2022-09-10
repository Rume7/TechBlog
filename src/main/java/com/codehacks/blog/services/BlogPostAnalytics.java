package com.codehacks.blog.services;

import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BlogPostAnalytics implements BlogPostAnalyticsInterface {

    @Autowired
    private BlogPostService blogPostService;

    @Override
    public Map<String, List<Comment>> getCommentsForAllBlogPosts() {
        List<BlogPost> allPosts = blogPostService.getAllBlogPosts();
        return null;
    }

    @Override
    public Map<String, Integer> getNumberOfCommentsForAllBlogPosts() {
        List<BlogPost> allPosts = blogPostService.getAllBlogPosts();
        return null;
    }

    @Override
    public Double getAverageStarRatingForABlogPost(String title) {
        return null;
    }
}
